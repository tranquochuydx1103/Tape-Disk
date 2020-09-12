package GiaoDien;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Database.Database;
import DieuKhien.QuanLyHoaDon;
import DieuKhien.QuanLyKhachHang;
import DoiTuong.KhachHang;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Font;

public class GiaoDienDanhSachKhachHang extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tableModel;
	private QuanLyKhachHang qlkh;
	private QuanLyHoaDon HD;
	private List<KhachHang> dskh;
	private JTextField txtsdt;
	private JButton btntimKiem, btnthem, btnthueBangDia;
	private JLabel lblsdt;
	private JButton btnTroVe;
	private String maNV;

	public GiaoDienDanhSachKhachHang(String maNV) {
		this.maNV = maNV;
		setTitle("Giao Diện Khách Hàng");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1068, 730);
		setLocationRelativeTo(null);
		taoGiaoDien();
	}

	public void taoGiaoDien() {
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		String[] header = "Mã Khách Hàng; Tên Khách Hàng; Số Điện Thoại ; CMND".split(";");
		tableModel = new DefaultTableModel(header, 0);
		JScrollPane scrollPane = new JScrollPane(table = new JTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		contentPane.add(scrollPane);
		scrollPane.setBounds(12, 68, 1030, 506);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Thanh T\u00ECm Ki\u1EBFm ",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel.setBounds(12, 597, 462, 83);
		contentPane.add(panel);
		panel.setLayout(null);

		lblsdt = new JLabel("Số Điện Thoại:");
		lblsdt.setBounds(10, 33, 95, 25);
		panel.add(lblsdt);

		txtsdt = new JTextField();
		txtsdt.setBounds(94, 33, 196, 24);
		panel.add(txtsdt);
		txtsdt.setColumns(10);
		txtsdt.setBackground(Color.WHITE);

		btntimKiem = new JButton("Tìm kiếm");
		btntimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btntimKiem.setBounds(300, 24, 129, 39);
		panel.add(btntimKiem);
		btntimKiem.setBackground(Color.WHITE);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "C\u00E1c Thao T\u00E1c",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(484, 597, 558, 83);
		contentPane.add(panel_1);

		btnthem = new JButton("Thêm Khách Hàng ");
		btnthem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnthem.setBounds(20, 22, 171, 39);
		panel_1.add(btnthem);
		btnthem.setBackground(Color.WHITE);

		btnthueBangDia = new JButton("Thuê Băng Đĩa");
		btnthueBangDia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnthueBangDia.setBounds(221, 22, 153, 39);
		panel_1.add(btnthueBangDia);
		btnthueBangDia.setBackground(Color.GREEN);

		btnTroVe = new JButton("Trở Về");
		btnTroVe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTroVe.setBackground(Color.WHITE);
		btnTroVe.setBounds(407, 22, 129, 39);
		panel_1.add(btnTroVe);

		JLabel lblDanhSchKhch = new JLabel("Danh Sách Khách Hàng");
		lblDanhSchKhch.setForeground(Color.BLUE);
		lblDanhSchKhch.setFont(new Font("Arial", Font.BOLD, 30));
		lblDanhSchKhch.setBounds(345, 11, 392, 52);
		contentPane.add(lblDanhSchKhch);
		btntimKiem.addActionListener(this);
		btnthueBangDia.addActionListener(this);
		btnthem.addActionListener(this);
		btnTroVe.addActionListener(this);
		capNhatBangDuLieu();
	}

	private void capNhatBangDuLieu() {
		int rowCount = table.getRowCount();
		for (int i = rowCount; i > 0; i--) {
			tableModel.removeRow(i - 1);
		}
		qlkh = new QuanLyKhachHang();
		List<KhachHang> list = qlkh.docTuBang();
		for (KhachHang khachHang : list) {
			String[] rowData = { khachHang.getMaKH(), khachHang.getHoTen(), khachHang.getSdt(), khachHang.getcMND() };
			tableModel.addRow(rowData);
			// cbotimKiem.addItem(khachHang.getHoTen());
		}
		table.setModel(tableModel);
	}

	private void capNhatBangDuLieuTimKiem(String soDienThoai) {
		int rowCount = table.getRowCount();
		for (int i = rowCount; i > 0; i--) {
			tableModel.removeRow(i - 1);
		}
		qlkh = new QuanLyKhachHang();
		List<KhachHang> list = qlkh.timKiemTheoSDTKhachHang(soDienThoai);
		for (KhachHang khachHang : list) {
			String[] rowData = { khachHang.getMaKH(), khachHang.getHoTen(), khachHang.getSdt(), khachHang.getcMND() };
			tableModel.addRow(rowData);
			// cbotimKiem.addItem(khachHang.getHoTen());
		}
		table.setModel(tableModel);
	}

	private boolean kiemTraKhachHang(String maKH) {
		qlkh = new QuanLyKhachHang();
		List<KhachHang> list = qlkh.kiemTraKhachHangDangThue();
		for (KhachHang khachHang : list) {
			if (maKH.trim().equals(khachHang.getMaKH().trim()))
				return false;
		}
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if (ob.equals(btntimKiem)) {
			String soDienThoai = txtsdt.getText();
			capNhatBangDuLieuTimKiem(soDienThoai.trim());

		} else if (ob.equals(btnthem)) {
			GiaoDienThemKhachHang kh = new GiaoDienThemKhachHang(maNV);
			kh.setVisible(true);
			setVisible(false);

		} else if (ob.equals(btnthueBangDia)) {
			int row = table.getSelectedRow();
			if (row != -1) {
				String maKH = (String) table.getValueAt(row, 0);
				if (kiemTraKhachHang(maKH)) {
					GiaoDienThueBangDia thue = new GiaoDienThueBangDia(maKH, maNV);
					thue.setVisible(true);
					setVisible(false);
				} else
					JOptionPane.showMessageDialog(this, "Khách Hàng Đang Có Phiếu Thuê Chưa Trả !");
			} else 
				JOptionPane.showMessageDialog(this, "Hãy chọn một khách hàng !");
		} else if (ob.equals(btnTroVe)) {
			setVisible(false);
		}

	}
}
