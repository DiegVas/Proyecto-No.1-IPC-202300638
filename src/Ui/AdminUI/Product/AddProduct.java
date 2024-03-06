package Ui.AdminUI.Product;

import classes.BaseData;
import classes.FrameWindow;
import classes.TextfiledContructor;
import classes.UiConts;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class AddProduct {
    public AddProduct() {
        FrameWindow window = new FrameWindow("Agregar producto", 550, 700);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.add(AddPatientP(window));
    }

    public JPanel AddPatientP(JFrame Actualframe) {
        UiConts conts = new UiConts();

        JPanel addProductPanel = new JPanel();
        addProductPanel.setLayout(new BorderLayout());
        addProductPanel.setBounds(0, 0, 500, 700);

        JLabel title = new JLabel();
        title.setText("Añadir producto");
        title.setFont(conts.boldText(30));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setForeground(conts.TextColor);
        title.setPreferredSize(new Dimension(0, 100));

        JPanel form = new JPanel();
        form.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));

        TextfiledContructor contructor = new TextfiledContructor(200, 40);

        JTextField product = new JTextField();
        JPanel namePanel = contructor.createTextfield("Producto", product);
        form.add(namePanel);

        JTextField description = new JTextField();
        JPanel descriptionPanel = contructor.createTextfield("Descripcion", description);
        form.add(descriptionPanel);

        JTextField price = new JTextField();
        JPanel pricePanel = contructor.createTextfield("Precio", price);
        form.add(pricePanel);

        JTextField count = new JTextField();
        JPanel countPanel = contructor.createTextfield("Cantidad", count);
        form.add(countPanel);

        JButton aProduct = new JButton();
        aProduct.setPreferredSize(new Dimension(250, 50));
        aProduct.setText("Agregar producto");
        aProduct.setBackground(conts.TextColor);
        aProduct.setForeground(Color.white);
        aProduct.setBorder(BorderFactory.createEtchedBorder());
        aProduct.setFocusable(false);

        aProduct.addActionListener(e -> {
            String productI = product.getText(), descriptionI = description.getText(), priceI = price.getText(), countI = count.getText();
            if (productI.isEmpty() || descriptionI.isEmpty() || !priceI.matches("\\d+(\\.\\d+)?") || !countI.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "Complete todas las casillas y por favor ingrese datos validos", "Agrear producto", JOptionPane.ERROR_MESSAGE);
            } else {
                BaseData newProduct = new BaseData();
                newProduct.addProduct(productI, descriptionI, Double.parseDouble(priceI), Integer.parseInt(countI));
                JOptionPane.showMessageDialog(null, "Producto agregado con exito", "Agregar prodcuto", JOptionPane.INFORMATION_MESSAGE);
                Object[] ProductoTab = {productI, descriptionI, priceI, countI};
                AdminProduct.model.addRow(ProductoTab);
                Actualframe.dispose();
            }
        });

        form.add(aProduct);
        addProductPanel.add(title, BorderLayout.NORTH);
        addProductPanel.add(form, BorderLayout.CENTER);
        return addProductPanel;
    }
}
