/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dao.TraHangDAO;
import entity.HoaDon;
import entity.HoaDonChiTiet;
import entity.TraHang;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utils.XLogin;

/**
 *
 * @author Trong Phu
 */
public class TraHang_View extends javax.swing.JPanel {

    TraHangDAO thDAO = new TraHangDAO();

    /**
     * Creates new form DoiTraHang_View
     */
    public TraHang_View() {
        initComponents();
        txtMaHoaDon.requestFocus();
        // txtTienThanhToan.setVisible(false);
    }

//    private void fillTableHoaDon(List<HoaDon> list) {
//        DefaultTableModel model = (DefaultTableModel) tblHDCT.getModel();
//        model.setRowCount(0);
//
//        Date now = new Date();
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//
//        for (HoaDon hd : list) {
//            try {
//                // Parse the string to a Date object
//                Date hanDoiTraDate = formatter.parse(hd.getHanDoiTra());
//                System.out.println("Hạn đổi trả " + hanDoiTraDate);
//                System.out.println("Ngày hôm nay " + now);
//                String trangThaiHanDoi = "";
//                // Compare the Date objects
//                if (hanDoiTraDate.compareTo(now) >= 0) {
//                    trangThaiHanDoi = "<html><font color='green'><b>Còn hạn</b></font></html>";
//                    System.out.println("Hạn trả trừ ngày hôm nay" + hanDoiTraDate.compareTo(now));
//                } else {
//                    trangThaiHanDoi = "<html><font color='red'><b>Hết hạn<b></font></html>";
//                    System.out.println("Hạn trả trừ ngày hôm nay" + hanDoiTraDate.compareTo(now));
//                }
//                model.addRow(new Object[]{
//                    hd.getMaHoaDon(),
//                    hd.getMaNhanVien(),
//                    hd.getTenNhanVien(),
//                    hd.getMaKhachHang(),
//                    hd.getTenKhachHang(),
//                    hd.getTongTien(),
//                    hd.getHinhThucThanhToan(),
//                    hd.getNgayTao(),
//                    hd.getTrangThai(),
//                    trangThaiHanDoi
//                });
//
//            } catch (ParseException e) {
//                // Handle the parsing exception if needed
//                e.printStackTrace();
//            }
//        }
//    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Quản lý sản phẩm view");

        TraHang_View dHV = new TraHang_View();
        frame.add(dHV);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void loadDataToTableHDCT(List<HoaDonChiTiet> lst) {
        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel) tblHDCT.getModel();
        model.setRowCount(0);
        for (HoaDonChiTiet hdct : lst) {
            model.addRow(new Object[]{
                hdct.getMaHDCT(),
                hdct.getMaSanPham(),
                hdct.getTenSanPham(),
                hdct.getSize(),
                hdct.getMauSac(),
                hdct.getChatLieu(),
                hdct.getNhaCC(),
                hdct.getGiaBan(),
                hdct.getSoLuong(),
                hdct.getThanhTien()
            });
        }
    }

    private void loadDataToTableTraHang(List<TraHang> lst) {
        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel) tblTraHang.getModel();
        model.setRowCount(0);
        for (TraHang hdct : lst) {

            model.addRow(new Object[]{
                hdct.getHoaDon_id(),
                hdct.getsPCT_id(),
                hdct.getTenSP(),
                hdct.getSize(),
                hdct.getMauSac(),
                hdct.getChatLieu(),
                hdct.getTenNCC(),
                hdct.getGiaTra(),
                hdct.getSoLuongTra(),
                hdct.getTongTienHoanTra(),
                hdct.getLyDoTraHang(),
                hdct.getNgayTraHang(),
                hdct.getNhanVien_id()
            });
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPopupTraHang = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMaHoaDon = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTenKhachHang = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTienThanhToan = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTienHoanTra = new javax.swing.JTextField();
        btnTimKiemHD = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblHDCT = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        lblHanTra = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTraHang = new javax.swing.JTable();

        jMenuItem1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Add to basket.png"))); // NOI18N
        jMenuItem1.setText("Trả hàng");
        jMenuItem1.setToolTipText("");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        JPopupTraHang.add(jMenuItem1);

        setPreferredSize(new java.awt.Dimension(1145, 683));

        jTabbedPane1.setOpaque(true);

        jPanel1.setBackground(new java.awt.Color(255, 251, 246));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "QUẢN LÝ TRẢ HÀNG", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24))); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Form trả hàng"));

        jLabel1.setText("Mã hoá đơn");

        jLabel3.setText("Khách hàng");

        txtTenKhachHang.setEditable(false);
        txtTenKhachHang.setBackground(new java.awt.Color(239, 239, 239));

        jLabel4.setText("Tiền còn lại của hoá đơn");

        txtTienThanhToan.setEditable(false);
        txtTienThanhToan.setBackground(new java.awt.Color(239, 239, 239));

        jLabel5.setText("Tiền hoàn trả");

        txtTienHoanTra.setEditable(false);
        txtTienHoanTra.setBackground(new java.awt.Color(239, 239, 239));

        btnTimKiemHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search3.png"))); // NOI18N
        btnTimKiemHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemHDActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách sản phẩm đã mua"));

        tblHDCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HDCT", "Mã sản phầm", "Tên sản phẩm", "Size", "Màu sắc", "Chất liệu", "Nhà cung cấp", "Đơn giá", "Số lượng", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHDCT.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                tblHDCTMouseDragged(evt);
            }
        });
        tblHDCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHDCTMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblHDCT);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jLabel2.setText("Hạn trả");

        lblHanTra.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblHanTra.setText("HanTra");

        jButton2.setBackground(new java.awt.Color(255, 204, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Add to basket.png"))); // NOI18N
        jButton2.setText("Xuất file phiếu trả hàng");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTienThanhToan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                            .addComponent(txtTienHoanTra, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblHanTra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTenKhachHang, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(37, 37, 37)
                        .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTimKiemHD)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(147, 147, 147))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiemHD, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHanTra, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 43, Short.MAX_VALUE)
                        .addComponent(jLabel3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTienThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTienHoanTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(99, 99, 99))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(23, 23, 23))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách sản phẩm đã trả", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        tblTraHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HD", "Mã sản phẩm", "Tên sản phẩm", "Size", "Màu sắc", "Chất liệu", "Nhà cung cấp", "Đơn giá trả", "Số lượng trả", "Tiền hoàn trả", "Lý do trả", "Ngày trả hàng", "Nhân viên"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTraHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTraHangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblTraHang);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1050, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(46, 46, 46)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        jTabbedPane1.addTab("Trả hàng", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimKiemHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemHDActionPerformed
        // TODO add your handling code here:

        if (null != thDAO.timHoaDon(txtMaHoaDon.getText())) {
            System.out.println("Tìm thấy hoá đơn cần trả!!");
            // fillTableHoaDon(thDAO.timHoaDon(txtMaHoaDon.getText()));
            if (null != thDAO.selectTraHangBYHoaDon_id(txtMaHoaDon.getText())) {
                System.out.println("Nếu hoá đơn đã từng trả sẽ in ra danh sách hàng dã trả");

                loadDataToTableTraHang(thDAO.selectTraHangBYHoaDon_id(txtMaHoaDon.getText()));
                System.out.println("Load bảng trả hàng!!");
                BigDecimal tienDaHoan = BigDecimal.valueOf(0);
                for (int i = 0; i < tblTraHang.getRowCount(); i++) {
                    BigDecimal tienHoanTheoSanPham = BigDecimal.valueOf(Double.parseDouble(tblTraHang.getValueAt(i, 9).toString()));
                    tienDaHoan = tienDaHoan.add(tienHoanTheoSanPham);
                    System.out.println(tienDaHoan);
                }
                txtTienHoanTra.setText(tienDaHoan + "");
            }
            loadDataToTableHDCT(thDAO.selectHDCTByHoaDon_id(txtMaHoaDon.getText()));
            Date now = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            for (HoaDon hd : thDAO.timHoaDon(txtMaHoaDon.getText())) {
                Date hanDoiTraDate = null;
                try {
                    hanDoiTraDate = formatter.parse(hd.getHanDoiTra());
                } catch (ParseException ex) {
                    Logger.getLogger(TraHang_View.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Hạn đổi trả " + hanDoiTraDate);
                System.out.println("Ngày hôm nay " + now);
                String trangThaiHanDoi = "";
                // Compare the Date objects
                if (hanDoiTraDate.compareTo(now) >= 0) {
                    trangThaiHanDoi = "<html><font color='green'><b>Còn hạn</b></font></html>";
                    System.out.println("Hạn trả trừ ngày hôm nay " + hanDoiTraDate.compareTo(now));

                } else {
                    trangThaiHanDoi = "<html><font color='red'><b>Hết hạn<b></font></html>";
                    System.out.println("Hạn trả trừ ngày hôm nay " + hanDoiTraDate.compareTo(now));
                }
                txtTenKhachHang.setText(hd.getTenKhachHang());
                // txtTienHoanTra.setText("");
                txtTienThanhToan.setText(hd.getTongTien() + "");
                lblHanTra.setText(trangThaiHanDoi);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy hoá đơn cần trả!!");
            txtMaHoaDon.setText("");
            txtTenKhachHang.setText("");
            txtTienHoanTra.setText("");
            txtTienThanhToan.setText("");
            loadDataToTableTraHang(thDAO.selectTraHangBYHoaDon_id(""));
            loadDataToTableHDCT(thDAO.selectHDCTByHoaDon_id(""));
        }


    }//GEN-LAST:event_btnTimKiemHDActionPerformed

    private void tblTraHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTraHangMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblTraHangMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        if (Integer.parseInt(tblHDCT.getValueAt(tblHDCT.getSelectedRow(), 8).toString()) <= 0) {
            JOptionPane.showMessageDialog(this, "Sản phầm này đã trả hết!!");
        } else {

            if (checkFormHDCT()) {

                String sPCT_id = tblHDCT.getValueAt(tblHDCT.getSelectedRow(), 1).toString();
                String hDCT_id = tblHDCT.getValueAt(tblHDCT.getSelectedRow(), 0).toString();
                String lyDoTra = JOptionPane.showInputDialog(this, "Lý do trả");

//            BigDecimal tongTien = BigDecimal.ZERO; // Khởi tạo tongTien với giá trị 0 trước khi lặp
//            for (int i = 0; i < tblTraHang.getRowCount(); i++) {
//                // int soLuong = Integer.parseInt(tblTraHang.getValueAt(i, 8).toString());
//                BigDecimal donGia = BigDecimal.valueOf(Double.parseDouble(tblTraHang.getValueAt(i, 7).toString()));
//                BigDecimal tongTien2 = donGia.multiply(BigDecimal.valueOf(soLuongTra)); // Sử dụng multiply() để nhân BigDecimal
//                tongTien = tongTien.add(tongTien2); // Tích tụ số tiền tổng
//            }
                BigDecimal giaTra = BigDecimal.valueOf(Double.parseDouble(tblHDCT.getValueAt(tblHDCT.getSelectedRow(), 7).toString()));
                BigDecimal tienHoanTra = giaTra.multiply(BigDecimal.valueOf(soLuongTra));
                txtTienHoanTra.setText(tienHoanTra + "");
                BigDecimal tongTienHoaDon = BigDecimal.valueOf(Double.parseDouble(txtTienThanhToan.getText()));
                if (tongTienHoaDon.subtract(tienHoanTra).compareTo(BigDecimal.ZERO) > 0) {
                    tongTienHoaDon = tongTienHoaDon.subtract(tienHoanTra);
                } else {
                    tongTienHoaDon = tienHoanTra.subtract(tongTienHoaDon);
                }
                thDAO.traHang(txtMaHoaDon.getText(), sPCT_id, hDCT_id, XLogin.user.getNhanVien_id(), soLuongTra, lyDoTra, tongTienHoaDon);
                // Bây giờ, 'tongTien' chứa tổng số tiền

                loadDataToTableHDCT(thDAO.selectHDCTByHoaDon_id(txtMaHoaDon.getText()));
                loadDataToTableTraHang(thDAO.selectTraHangBYHoaDon_id(txtMaHoaDon.getText()));
                BigDecimal tienDaHoan = BigDecimal.valueOf(0);
                for (int i = 0; i < tblTraHang.getRowCount(); i++) {
                    BigDecimal tienHoanTheoSanPham = BigDecimal.valueOf(Double.parseDouble(tblTraHang.getValueAt(i, 9).toString()));
                    tienDaHoan = tienDaHoan.add(tienHoanTheoSanPham);
                    System.out.println(tienDaHoan);
                }
                txtTienHoanTra.setText(tienDaHoan + "");
                for (HoaDon hd : thDAO.timHoaDon(txtMaHoaDon.getText())) {
                    txtTenKhachHang.setText(hd.getTenKhachHang());
                    txtTienThanhToan.setText(hd.getTongTien() + "");
                }
            }
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void tblHDCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHDCTMouseClicked
        // TODO add your handling code here:
        if (lblHanTra.getText().equalsIgnoreCase("<html><font color='red'><b>Hết hạn<b></font></html>")) {
            JOptionPane.showMessageDialog(this, "Hoá đơn này dã hết hạn trả!!!");
        } else {
            JPopupTraHang.show(tblHDCT, evt.getX(), evt.getY());

        }


    }//GEN-LAST:event_tblHDCTMouseClicked

    private void tblHDCTMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHDCTMouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_tblHDCTMouseDragged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        if (txtMaHoaDon.getText().isEmpty() || tblTraHang.getRowCount() < 1) {
            JOptionPane.showMessageDialog(this, "Hoá đơn này chưa thực hiện trả hàng!!");
        } else {
            int choice2 = JOptionPane.showConfirmDialog(this, "Bạn muốn in hoá đơn này!!", "IN PHIẾU TRẢ HÀNG", JOptionPane.YES_OPTION);
            if (choice2 == JOptionPane.YES_OPTION) {
                String path = "";
                JFileChooser jfile = new JFileChooser();
                jfile.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int x = jfile.showSaveDialog(this);
                if (x == JFileChooser.APPROVE_OPTION) {
                    path = jfile.getSelectedFile().getAbsolutePath();
                    System.out.println(path);
                }
                Document doc = new Document();
                try {
                    PdfWriter.getInstance(doc, new FileOutputStream(path + "/" + "PhieuTraHang" + txtMaHoaDon.getText() + ".pdf"));
                    String filePath = path + "/" + "PhieuTraHang" + txtMaHoaDon.getText() + ".pdf";
                    doc.open();// mở luồng ghi file

                    String hoaDon_id = txtMaHoaDon.getText();
                    String tenKhachHang = txtTenKhachHang.getText();
                    //String ngayTaoHoaDon = tblHD.getValueAt(tblHD.getSelectedRow(), 7).toString();
                    Date now = new Date();
                    SimpleDateFormat fomater = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    String nowS = fomater.format(now);
                    // tao logo cho hoa don
                    URL url = TrangChu.class.getResource("/img/nike.png");
                    Image logo = Image.getInstance(url);
                    logo.scaleAbsolute(60f, 60f); // Điều chỉnh kích thước của logo
                    logo.setAlignment(Element.ALIGN_LEFT);
                    doc.add(logo);
                    // set tieu de cho hoa don
                    com.itextpdf.text.Font titleFont = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 32, com.itextpdf.text.Font.BOLD, BaseColor.BLACK);
                    Paragraph title = new Paragraph("PHIEU TRA HANG NIKE ", titleFont);
                    title.setAlignment(Paragraph.ALIGN_CENTER);
                    doc.add(title);
                    doc.add(new Paragraph("\n"));
                    //goi ra cac doan thong tin
                    //tạo phông chữ cho các tiêu đề thông tin
                    com.itextpdf.text.Font infoFont = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 12, com.itextpdf.text.Font.NORMAL, BaseColor.DARK_GRAY);
                    doc.add(new Paragraph("Ma hoa don: " + hoaDon_id, infoFont));
                    doc.add(new Paragraph("Ten khach hang: " + removeDiacritics(tenKhachHang), infoFont));
                    doc.add(new Paragraph("Ngay xuat phieu: " + nowS, infoFont));
                    doc.add(new Paragraph("Nguoi xuat phieu: " + removeDiacritics(XLogin.user.getHoTen()), infoFont));

                    doc.add(new Paragraph("Tong tien hoan tra: " + txtTienHoanTra.getText(), infoFont));
                    doc.add(new Paragraph("\n"));
                    doc.add(new Paragraph("\n"));
                    doc.add(new Paragraph("Danh sach san pham da tra"));
                    ///tạo phông chữ cho bảng
                    com.itextpdf.text.Font timesNewRoman = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 12, com.itextpdf.text.Font.BOLD, BaseColor.DARK_GRAY);
                    com.itextpdf.text.Font timesNewRoman2 = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 12, com.itextpdf.text.Font.NORMAL, BaseColor.DARK_GRAY);

                    // Tạo bảng
                    PdfPTable tbl = new PdfPTable(8);
                    tbl.setWidthPercentage(100);
                    tbl.setSpacingBefore(10f);
                    tbl.setSpacingAfter(10f);

                    // Tieu de bang
                    PdfPCell cell1 = new PdfPCell(new Phrase("Ten san pham", timesNewRoman));
                    cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    tbl.addCell(cell1);

                    PdfPCell cell2 = new PdfPCell(new Phrase("Size", timesNewRoman));
                    cell2.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    tbl.addCell(cell2);

                    PdfPCell cell3 = new PdfPCell(new Phrase("Mau sac", timesNewRoman));
                    cell3.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    tbl.addCell(cell3);

                    PdfPCell cell4 = new PdfPCell(new Phrase("Chat lieu", timesNewRoman));
                    cell4.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    tbl.addCell(cell4);

                    PdfPCell cell5 = new PdfPCell(new Phrase("Hang", timesNewRoman));
                    cell5.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    tbl.addCell(cell5);

                    PdfPCell cell6 = new PdfPCell(new Phrase("Don gia tra", timesNewRoman));
                    cell6.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    tbl.addCell(cell6);

                    PdfPCell cell7 = new PdfPCell(new Phrase("So luong tra", timesNewRoman));
                    cell7.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    tbl.addCell(cell7);

                    PdfPCell cell8 = new PdfPCell(new Phrase("Thanh tien", timesNewRoman));
                    cell8.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    tbl.addCell(cell8);

                    //  Bang Du lieu san pham
                    for (int i = 0; i < tblTraHang.getRowCount(); i++) {
                        //   if (!tblHDCT.getValueAt(i, 7).toString().equals("0")) {
                        tbl.addCell(new PdfPCell(new Phrase(removeDiacritics(tblTraHang.getValueAt(i, 2).toString()), timesNewRoman2)));
                        tbl.addCell(new PdfPCell(new Phrase(removeDiacritics(tblTraHang.getValueAt(i, 3).toString()), timesNewRoman2)));
                        tbl.addCell(new PdfPCell(new Phrase(removeDiacritics(tblTraHang.getValueAt(i, 4).toString()), timesNewRoman2)));
                        tbl.addCell(new PdfPCell(new Phrase(removeDiacritics(tblTraHang.getValueAt(i, 5).toString()), timesNewRoman2)));
                        tbl.addCell(new PdfPCell(new Phrase(removeDiacritics(tblTraHang.getValueAt(i, 6).toString()), timesNewRoman2)));
                        tbl.addCell(new PdfPCell(new Phrase(removeDiacritics(tblTraHang.getValueAt(i, 7).toString()), timesNewRoman2)));
                        tbl.addCell(new PdfPCell(new Phrase(removeDiacritics(tblTraHang.getValueAt(i, 8).toString()), timesNewRoman2)));
                        tbl.addCell(new PdfPCell(new Phrase(removeDiacritics(tblTraHang.getValueAt(i, 9).toString()), timesNewRoman2)));
                        // }

                    }

//                PdfPCell totalCell = new PdfPCell(new Phrase("Thanh tien: " + lblTongTien.getText(), timesNewRoman));
//                totalCell.setColspan(8); // Đặt colspan bằng số lượng cột của bảng
//                totalCell.setHorizontalAlignment(Element.ALIGN_RIGHT); // Căn chỉnh về bên phải
//                tbl.addCell(totalCell);
                    doc.add(tbl);

                    doc.add(new Paragraph("\n"));
                    doc.add(new Paragraph("\n"));

                    com.itextpdf.text.Font titleFont2 = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 20, com.itextpdf.text.Font.BOLD, BaseColor.BLACK);
                    com.itextpdf.text.Font hanTraFont = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 12, com.itextpdf.text.Font.BOLD, BaseColor.BLACK);

                    Paragraph hanTra = new Paragraph("Xin loi quy khach vi trai nghiem khong tot!!", hanTraFont);
                    doc.add(hanTra);

                    Paragraph title2 = new Paragraph("CHUC QUY KHACH MUA SAM VUI VE!!!!", titleFont2);
                    doc.add(title2);
                    doc.add(new Paragraph("\n"));

                    //Tạo footer bằng bảng
                    PdfPTable footer = new PdfPTable(1);
                    footer.setWidthPercentage(100);
                    footer.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);

                    // Tạo font Times New Roman cho footer
                    com.itextpdf.text.Font footerFont = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 12, com.itextpdf.text.Font.BOLD, BaseColor.BLACK);

                    // Thêm nội dung footer với font Times New Roman
                    PdfPCell footerCell = new PdfPCell(new Phrase("----------------------------- CAM ON QUY KHACH DA LUA CHON CUA HANG ---------------------------", footerFont));
                    footer.addCell(footerCell);
                    doc.add(footer);

                    doc.close();
                    System.out.println("Xuất hoá đơn bán lẻ nè hhihi");
                    int choice = JOptionPane.showConfirmDialog(this, "Xem hoá đơn vừa tạo?", "XEM HOÁ ĐƠN", JOptionPane.YES_OPTION);
                    if (choice == JOptionPane.YES_OPTION) {
                        openPdfFile(filePath);
                    }
                } catch (DocumentException ex) {
                    Logger.getLogger(HoaDon_View.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(HoaDon_View.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(HoaDon_View.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private static void openPdfFile(String filePath) {
        try {
            File file = new File(filePath);
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(file);
            } else {
                System.out.println("Desktop is not supported");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String removeDiacritics(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        input = input.replace("Đ", "D");
        input = input.replace("đ", "d");
        String decomposed = Normalizer.normalize(input, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(decomposed).replaceAll("");
    }

    int soLuongTra = 0;

    boolean checkFormHDCT() {
        String soLuongTraString;

        do {
            soLuongTraString = JOptionPane.showInputDialog(this, "Nhập số lượng muốn trả!!");
            if (soLuongTraString == null) {
                return false;
            }

            if (soLuongTraString.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Không được để trống số lượng!!");
                return false;
            } else {
                try {
                    soLuongTra = Integer.parseInt(soLuongTraString);

                    if (soLuongTra <= 0) {
                        JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0!!");
                        return false;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Số lượng phải là số!!");
                    return false;
                }
            }
            if (soLuongTra > Integer.parseInt(tblHDCT.getValueAt(tblHDCT.getSelectedRow(), 8).toString())) {
                JOptionPane.showMessageDialog(this, "Số lượng sản phẩm trả không đủ!!");
            } else {
                break;
            }
        } while (true);

        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu JPopupTraHang;
    private javax.swing.JButton btnTimKiemHD;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblHanTra;
    private javax.swing.JTable tblHDCT;
    private javax.swing.JTable tblTraHang;
    private javax.swing.JTextField txtMaHoaDon;
    private javax.swing.JTextField txtTenKhachHang;
    private javax.swing.JTextField txtTienHoanTra;
    private javax.swing.JTextField txtTienThanhToan;
    // End of variables declaration//GEN-END:variables
}
