package Ui.PatientUI;

import classes.BaseData;
import classes.TypeClass;
import classes.UiConts;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class farmacyShow {

    List<TypeClass.Product> productList = new ArrayList<>();

    farmacyShow() {
        productList = new BaseData().getProductList();
    }

    public JPanel farmacyPanel() {
        UiConts conts = new UiConts();
        JPanel farmacyPane = new JPanel();
        farmacyPane.setLayout(new BorderLayout(10, 30));
        farmacyPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel farmacyTitle = new JLabel();
        farmacyTitle.setText("FARMACIA");
        farmacyTitle.setFont(conts.boldText(25));
        farmacyTitle.setForeground(conts.background);
        farmacyPane.add(farmacyTitle, BorderLayout.NORTH);

        JPanel listProducts = new JPanel();
        listProducts.setLayout(new GridLayout(3, 2, 10, 10));

        for (TypeClass.Product product : productList) {
            JPanel productPanel = new JPanel();
            productPanel.setBackground(conts.background);
            productPanel.setLayout(new BorderLayout());
            productPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

            JLabel titleProduct = new JLabel(product.product);
            titleProduct.setFont(conts.boldText(18));
            titleProduct.setForeground(Color.white);
            productPanel.add(titleProduct, BorderLayout.NORTH);

            JLabel descriptionProduct = new JLabel(product.description);
            descriptionProduct.setFont(conts.plainText(15));
            descriptionProduct.setForeground(Color.white);
            descriptionProduct.setHorizontalAlignment(JLabel.LEFT);
            productPanel.add(descriptionProduct, BorderLayout.CENTER);

            JPanel footInfo = new JPanel();
            footInfo.setBackground(conts.background);
            footInfo.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 5));

            JLabel priceProduct = new JLabel("Q " + String.valueOf(product.price));
            priceProduct.setFont(conts.plainText(15));
            priceProduct.setForeground(Color.white);
            footInfo.add(priceProduct);

            JLabel CountPrice = new JLabel("Disponibles: " + String.valueOf(product.count));
            CountPrice.setFont(conts.plainText(15));
            CountPrice.setForeground(Color.white);
            footInfo.add(CountPrice);
            productPanel.add(footInfo, BorderLayout.SOUTH);

            listProducts.add(productPanel);

        }

        farmacyPane.add(listProducts);
        return farmacyPane;
    }
}
