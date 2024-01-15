/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.HoaDon;
import entity.HoaDonChiTiet;
import entity.TraHang;
import java.math.BigDecimal;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import utils.DB_Connect;

/**
 *
 * @author Trong Phu
 */
public class TraHangDAO extends QLCHBG_DAO<TraHang, String> {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    @Override
    public int insert(TraHang entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(String key, TraHang entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<TraHang> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<HoaDon> timHoaDon(String maHD) {
        List<HoaDon> list1 = new ArrayList<>();
        sql = """
              Select hoaDon.hoaDon_id,
                                                        nhanVien.nhanVien_id, 
                                                        nhanVien.hoTen, 
                                                        khachHang.khachHang_id, 
                                                        khachHang.hoTenKH, 
                                                        tongTien,
                                                        thanhToan.hinhThucThanhToan,
                                                        hoaDon.ngayTaoHD,
                                                        hoaDon.trangThai ,
                                                        hoaDon.ghiChu ,
                                                        hoaDon.hanDoiTra
                                                        from hoaDon 
                                                        join nhanVien on nhanVien.nhanVien_id = hoaDon.nhanVien_id
                                                        join khachHang on khachHang.khachHang_id = hoaDon.khachHang_id
                                                        join thanhToan on thanhToan.thanhToan_id = hoaDon.thanhToan_id where hoaDon_id = ? and (hoaDon.trangThai like N'Hoàn thành' or hoaDon.trangThai like N'Trả hàng' ) order by ngayTaoHD
              """;
        try {
            con = DB_Connect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maHD);
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getBigDecimal(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11)
                );
                list1.add(hd);
            }
            if (!list1.isEmpty()) {
                return list1;
            } else {
                return null;
            }

        } catch (Exception e) {
            e.fillInStackTrace();
            return null;
        }

    }

    public ArrayList<HoaDonChiTiet> selectHDCTByHoaDon_id(String id) {
        ArrayList<HoaDonChiTiet> lst = new ArrayList<>();
        try {
            sql = """
                         select hoaDonChiTiet.hDCT_id,
                        hoaDon.hoaDon_id,
                        sanPhamChiTiet.sPCT_id,
                        sanPham.ten,
                        hoaDonChiTiet.soLuong,
                        hoaDonChiTiet.giaBan,
                        hoaDonChiTiet.thanhTien,
                        size.giaTri,
                        chatLieu.ten as tenChatLieu,
                        nhaCungCap.ten as tenNhaCC,
                        mauSac.tenMau,
                        hoaDonChiTiet.trangThaiHDCT
                        from hoaDonChiTiet
                                                                           join hoaDon on hoaDon.hoaDon_id = hoaDonChiTiet.hoaDon_id
                                                                           join sanPhamChiTiet on sanPhamChiTiet.sPCT_id = hoaDonChiTiet.sPCT_id
                                                                           join sanPham  on sanPhamChiTiet.sanPham_id = sanPham.sanPham_id
                                                                           join size on size.size_id = sanPhamChiTiet.size_id
                                                                           join chatLieu on chatLieu.chatLieu_id = sanPhamChiTiet.chatLieu_id
                                                                           join mauSac on mauSac.mauSac_id = sanPhamChiTiet.mauSac_id
                                                                           join nhaCungCap on nhaCungCap.nhaCC_id = sanPhamChiTiet.nhaCC_id 
                                                  where hoaDonChiTiet.hoaDon_id like ? and (trangThaiHDCT like N'Hoàn thành' or trangThaiHDCT like N'Trả hàng')
                         """;
            con = DB_Connect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonChiTiet hdct = new HoaDonChiTiet();
                hdct.setMaHDCT(rs.getString("hDCT_id"));
                hdct.setMaSanPham(rs.getString("sPCT_id"));
                hdct.setTenSanPham(rs.getString("ten"));
                hdct.setSize(rs.getInt("giaTri"));
                hdct.setChatLieu(rs.getString("tenChatLieu"));
                hdct.setNhaCC(rs.getString("tenNhaCC"));
                hdct.setMauSac(rs.getString("tenMau"));
                hdct.setGiaBan(rs.getBigDecimal("giaBan"));
                hdct.setSoLuong(rs.getInt("soLuong"));
                hdct.setThanhTien(rs.getBigDecimal("thanhTien"));
                hdct.setTrangThaiHDCT(rs.getString("trangThaiHDCT"));
                lst.add(hdct);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lst;
    }

    public int traHang(String hoaDon_id, String sPCT_id, String hDCT_id, String nhanVien_id, int soLuongTra, String lyDoTra, BigDecimal tongTienHoaDon) {
        sql = "{CALL procTraHang(?, ?, ?, ?, ?, ?, ?)}";
        try {
            con = DB_Connect.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(1, hoaDon_id);
            ps.setObject(2, sPCT_id);
            ps.setObject(3, hDCT_id);
            ps.setObject(4, nhanVien_id);
            ps.setObject(5, soLuongTra);
            ps.setObject(6, lyDoTra);
            ps.setObject(7, tongTienHoaDon);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

    public List<TraHang> selectTraHangBYHoaDon_id(String hoaDon_id) {
        sql = """
               select traHang.traHang_id,
                                                                                        hoaDon.hoaDon_id,
                                                                                        sanPhamChiTiet.sPCT_id,
                                                                                        sanPham.ten,
                                                                                        traHang.soLuongTra,
                                                                                        traHang.giaTra,
                                                                                        traHang.tongTienHoanTra,
                                                                                        size.giaTri,
                                                                                        chatLieu.ten as tenChatLieu,
                                                                                        nhaCungCap.ten as tenNhaCC,
                                                                                        mauSac.tenMau,
                                                                                        traHang.trangThai,
                                                                                        traHang.lyDoTraHang,
                                                                                        traHang.ngayTraHang,
                                                                                        traHang.nhanVien_id
                                                                                        from traHang
                                                             join hoaDon on hoaDon.hoaDon_id = traHang.hoaDon_id
                                                             join sanPhamChiTiet on sanPhamChiTiet.sPCT_id = traHang.sPCT_id
                                                             join sanPham  on sanPhamChiTiet.sanPham_id = sanPham.sanPham_id
                                                             join size on size.size_id = sanPhamChiTiet.size_id
                                                             join chatLieu on chatLieu.chatLieu_id = sanPhamChiTiet.chatLieu_id
                                                             join mauSac on mauSac.mauSac_id = sanPhamChiTiet.mauSac_id
                                                             join nhaCungCap on nhaCungCap.nhaCC_id = sanPhamChiTiet.nhaCC_id 
                                                             where traHang.hoaDon_id like ? """;
        List<TraHang> listTH = new ArrayList<>();
        try {
            con = DB_Connect.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(1, hoaDon_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                TraHang tH = new TraHang();
                tH.setHoaDon_id(rs.getString("hoaDon_id"));
                tH.setsPCT_id(rs.getString("sPCT_id"));
                tH.setTenSP(rs.getString("ten"));
                tH.setSize(rs.getInt("giaTri"));
                tH.setChatLieu(rs.getString("tenChatLieu"));
                tH.setTenNCC(rs.getString("tenNhaCC"));
                tH.setMauSac(rs.getString("tenMau"));
                tH.setGiaTra(rs.getBigDecimal("giaTra"));
                tH.setSoLuongTra(rs.getInt("soLuongTra"));
                tH.setTongTienHoanTra(rs.getBigDecimal("tongTienHoanTra"));
                tH.setTrangThai(rs.getString("trangThai"));
                tH.setLyDoTraHang(rs.getString("lyDoTraHang"));
                tH.setNgayTraHang(rs.getString("ngayTraHang"));
                tH.setNhanVien_id(rs.getString("nhanVien_id"));
                listTH.add(tH);
            }
            return listTH;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
