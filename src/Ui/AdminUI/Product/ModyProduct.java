package Ui.AdminUI.Product;

import classes.*;

import javax.swing.*;
import java.awt.*;

public class ModyProduct {

    TypeClass.Product modyProduct;
    int index;

    public ModyProduct(TypeClass.Product product, int index) {
        this.modyProduct = product;
        this.index = index;
        FrameWindow window = new FrameWindow("Agregar Paciente", 550, 700);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.add(AddPatientP(window));
    }

    public JPanel AddPatientP(JFrame Actualframe) {
        UiConts conts = new UiConts();

        JPanel ModyPatientPanel = new JPanel();
        ModyPatientPanel.setLayout(new BorderLayout());
        ModyPatientPanel.setBounds(0, 0, 500, 700);

        JLabel title = new JLabel();
        title.setText("Añadir producto");
        title.setFont(conts.boldText(30));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setForeground(conts.TextColor);
        title.setPreferredSize(new Dimension(0, 100));

        JPanel form = new JPanel();
        form.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));

        ComponentsContructor contructor = new ComponentsContructor(200, 40);

        JTextField product = new JTextField(modyProduct.product);
        JPanel namePanel = contructor.createTextfield("Producto", product);
        form.add(namePanel);

        JTextField description = new JTextField(modyProduct.description);
        JPanel descriptionPanel = contructor.createTextfield("Producto", description);
        form.add(descriptionPanel);

        JTextField price = new JTextField();
        price.setText(String.valueOf(modyProduct.price));
        JPanel pricePanel = contructor.createTextfield("Precio", price);
        form.add(pricePanel);

        JTextField count = new JTextField();
        count.setText(String.valueOf(modyProduct.count));
        JPanel countPanel = contructor.createTextfield("Cantidad", count);
        form.add(countPanel);

        JButton ModyProduct = new JButton();
        ModyProduct.setPreferredSize(new Dimension(250, 50));
        ModyProduct.setText("Agregar producto");
        ModyProduct.setBackground(conts.TextColor);
        ModyProduct.setForeground(Color.white);
        ModyProduct.setBorder(BorderFactory.createEtchedBorder());
        ModyProduct.setFocusable(false);

        ModyProduct.addActionListener(e -> {
            String ProductI = product.getText(), DescriptionI = description.getText(), priceI = price.getText(), countI = count.getText();
            if (ProductI.isEmpty() || DescriptionI.isEmpty() || !priceI.matches("\\d+(\\.\\d+)?") || !count.getText().matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "Complete todas las casillas y por favor ingrese datos validos", "Modificar Producto", JOptionPane.ERROR_MESSAGE);
            } else {
                BaseData modyProduct = new BaseData();
                modyProduct.changeProduct(index, new TypeClass.Product(ProductI, DescriptionI, Double.parseDouble(priceI), Integer.parseInt(countI)));
                JOptionPane.showMessageDialog(null, "Producto modificado con exito", "Modificar Prodcuto", JOptionPane.INFORMATION_MESSAGE);
                Object[] PatienteTab = {ProductI, DescriptionI, priceI, countI};

                AdminProduct.model.setValueAt(PatienteTab[0], index, 0);
                AdminProduct.model.setValueAt(PatienteTab[1], index, 1);
                AdminProduct.model.setValueAt(PatienteTab[2], index, 2);
                AdminProduct.model.setValueAt(PatienteTab[3], index, 3);
                Actualframe.dispose();
            }
        });

        form.add(ModyProduct);
        ModyPatientPanel.add(title, BorderLayout.NORTH);
        ModyPatientPanel.add(form, BorderLayout.CENTER);

        return ModyPatientPanel;
    }
}
