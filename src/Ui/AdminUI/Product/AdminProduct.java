package Ui.AdminUI.Product;

import classes.BaseData;
import classes.UiConts;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AdminProduct {

    public static DefaultTableModel model = new DefaultTableModel();

    public JPanel Panel() {

        String[] headers = {"Producto", "Descripcion", "precio", "Cantidad"};
        model.setColumnIdentifiers(headers);

        UiConts conts = new UiConts();
        JPanel aProductPanel = new JPanel();
        aProductPanel.setLayout(new BorderLayout(10, 30));
        aProductPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel tittleProduct = new JLabel();
        JTable ProductList = new JTable(model);
        ProductList.setForeground(conts.TextColor);
        ProductList.getTableHeader().setBackground(conts.background);
        ProductList.getTableHeader().setForeground(Color.white);
        JScrollPane scrollPane = new JScrollPane(ProductList);

        JPanel ButtonsPanel = new JPanel();
        ButtonsPanel.setPreferredSize(new Dimension(300, 500));
        ButtonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton AddProduct = new JButton();
        AddProduct.setPreferredSize(new Dimension(130, 50));
        AddProduct.setText("Agregar producto");
        AddProduct.setBackground(conts.TextColor);
        AddProduct.setForeground(Color.white);
        AddProduct.setBorder(BorderFactory.createEtchedBorder());
        AddProduct.setFocusable(false);
        AddProduct.addActionListener(e -> {
            AddProduct Producto = new AddProduct();
        });

        JButton ModyProduct = new JButton();
        ModyProduct.setPreferredSize(new Dimension(130, 50));
        ModyProduct.setText("Modificar Producto");
        ModyProduct.setBackground(conts.TextColor);
        ModyProduct.setForeground(Color.white);
        ModyProduct.setBorder(BorderFactory.createEtchedBorder());
        ModyProduct.setFocusable(false);
        ModyProduct.addActionListener(e -> {
            int index = ProductList.getSelectedRow();
            if (index == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione un producto", "Eliminar producto", JOptionPane.QUESTION_MESSAGE);
                return;
            }
            ModyProduct modyProduct = new ModyProduct(BaseData.productList.get(index), index);

        });

        JButton DeleteProduct = new JButton();
        DeleteProduct.setPreferredSize(new Dimension(250, 50));
        DeleteProduct.setText("Elminiar producto");
        DeleteProduct.setBackground(conts.TextColor);
        DeleteProduct.setForeground(Color.white);
        DeleteProduct.setBorder(BorderFactory.createEtchedBorder());
        DeleteProduct.setFocusable(false);
        DeleteProduct.addActionListener(e -> {
            int index = ProductList.getSelectedRow();
            if (index == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione un producto", "Eliminar producto", JOptionPane.QUESTION_MESSAGE);
                return;
            }

            int response = JOptionPane.showConfirmDialog(null, "Esta seguro de elminar el producto " + BaseData.productList.get(index).product, "Eliminar Paciente", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.NO_OPTION) return;

            BaseData.productList.remove(index);
            model.removeRow(index);
        });

        ButtonsPanel.add(AddProduct);
        ButtonsPanel.add(ModyProduct);
        ButtonsPanel.add(DeleteProduct);

        tittleProduct.setText("LISTADO PRODUCTO");
        tittleProduct.setFont(conts.boldText(25));
        tittleProduct.setForeground(conts.background);

        aProductPanel.add(ButtonsPanel, BorderLayout.EAST);
        aProductPanel.add(scrollPane, BorderLayout.CENTER);
        aProductPanel.add(tittleProduct, BorderLayout.NORTH);

        return aProductPanel;
    }
}
