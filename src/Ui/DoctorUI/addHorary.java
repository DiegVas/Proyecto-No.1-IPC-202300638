package Ui.DoctorUI;

import classes.BaseData;
import classes.TypeClass;
import classes.UiConts;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Optional;

public class addHorary {


    int indexDoctor;
    public DefaultTableModel model = new DefaultTableModel();

    addHorary(int indexDoctor) {
        this.indexDoctor = indexDoctor;
    }

    public JPanel HoraryTab() {
        UiConts conts = new UiConts();
        JPanel HoraryPanel = new JPanel();
        HoraryPanel.setLayout(new BorderLayout());
        HoraryPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        String[] headers = {"No.", "Horario de Cita"};
        model.setColumnIdentifiers(headers);

        JLabel HoraryTitle = new JLabel();
        HoraryTitle.setText("ASIGNAR HORARIO");
        HoraryTitle.setFont(conts.boldText(25));
        HoraryTitle.setForeground(conts.background);
        HoraryPanel.add(HoraryTitle, BorderLayout.NORTH);

        JPanel asingHorary = new JPanel();
        asingHorary.setLayout(new FlowLayout(0, 50, 50));
        asingHorary.setSize(new Dimension(500, 200));

        JLabel asignHoraryLabe = new JLabel();
        asignHoraryLabe.setText("Horario de Citas: ");
        asignHoraryLabe.setFont(conts.boldText(15));
        asignHoraryLabe.setForeground(conts.background);
        asingHorary.add(asignHoraryLabe);

        String[] Horarys = {"8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00"};
        JComboBox HorarySelect = new JComboBox(Horarys);
        HorarySelect.setSelectedItem(null);
        HorarySelect.setPreferredSize(new Dimension(250, 30));
        HorarySelect.setBackground(Color.white);
        HorarySelect.setForeground(conts.TextColor);
        HorarySelect.setFocusable(false);
        asingHorary.add(HorarySelect);

        JButton assginHoraryBu = new JButton();
        assginHoraryBu.setPreferredSize(new Dimension(150, 40));
        assginHoraryBu.setText("Añadir horario");
        assginHoraryBu.setBackground(conts.TextColor);
        assginHoraryBu.setForeground(Color.white);
        assginHoraryBu.setBorder(BorderFactory.createEtchedBorder());
        assginHoraryBu.setFocusable(false);
        assginHoraryBu.addActionListener(e -> {
            if (HorarySelect.getSelectedIndex() == -1)
                JOptionPane.showMessageDialog(null, "Seleccione un horario", "Error", JOptionPane.INFORMATION_MESSAGE);
            else {
                BaseData data = new BaseData();
                String time = Horarys[HorarySelect.getSelectedIndex()];
                Optional<String> HoraryFind = data.getDoctorList().get(indexDoctor).doctorHorary.stream().filter(times -> times.equals(time)).findFirst();
                if (HoraryFind.isPresent())
                    JOptionPane.showMessageDialog(null, "Seleccione un horario distinto", "Error", JOptionPane.INFORMATION_MESSAGE);
                else {
                    Object[] dataRow = {model.getRowCount() + 1, time};
                    data.getDoctorList().get(indexDoctor).doctorHorary.add(time);
                    model.addRow(dataRow);
                }
            }
        });
        asingHorary.add(assginHoraryBu);

        JButton deleteHorary = new JButton();
        deleteHorary.setPreferredSize(new Dimension(150, 40));
        deleteHorary.setText("Eliminar horario");
        deleteHorary.setBackground(conts.TextColor);
        deleteHorary.setForeground(Color.white);
        deleteHorary.setBorder(BorderFactory.createEtchedBorder());
        deleteHorary.setFocusable(false);
        deleteHorary.addActionListener(e -> {

            BaseData.doctorList.get(indexDoctor).doctorHorary.remove(HorarySelect.getSelectedIndex());
            model.removeRow(HorarySelect.getSelectedIndex());

        });
        asingHorary.add(deleteHorary);

        JPanel HoraryListP = new JPanel();
        HoraryListP.setPreferredSize(new Dimension(825, 250));
        HoraryListP.setLayout(new BorderLayout());
        JTable HoraryList = new JTable(model);

        HoraryList.setForeground(conts.TextColor);
        HoraryList.getTableHeader().setBackground(conts.background);
        HoraryList.getTableHeader().setForeground(Color.white);
        JScrollPane scrollPane = new JScrollPane(HoraryList);
        HoraryListP.add(scrollPane, BorderLayout.CENTER);
        asingHorary.add(HoraryListP);

        HoraryPanel.add(asingHorary, BorderLayout.CENTER);
        return HoraryPanel;
    }
}
