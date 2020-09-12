package GiaoDien;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Database.Database;
import DieuKhien.QuanLyBangDia;
import DieuKhien.QuanLyNhaCungCap;
import DieuKhien.QuanLyTheLoai;
import DoiTuong.BangDia;
import DoiTuong.NhaCungCap;
import DoiTuong.TheLoai;

import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class GiaoDienQuanLyBangDia extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JTextField txtGiaChoThue, txtMaBangDia, txtTenBangDia;
	private JTable table;
	private QuanLyBangDia BD;
	private QuanLyNhaCungCap NCC;
	private QuanLyTheLoai TL;
	private JComboBox<String> cboNCC, cboTheLoai;
	// private List<BangDia> list;
	private DefaultTableModel tablemodel;
	private JLabel lblSoLuong;
	private JPanel panel_1;
	private JTextField txtSoLuong;
	private JTextArea txaMoTa;
	private JButton btnThem, btnCapNhat, btnTimKiem, btnXemAll, btnTroVe;
	private JButton btnXoaRong;
	private JPanel panel_2;

	public GiaoDienQuanLyBangDia() {
		giaoDien();
		capNhatBangDuLieu();
	}

	public GiaoDienQuanLyBangDia(String tenBD, String tenNCC, String tenTL, double min, double max) {
		giaoDien();
		timKiem(tenBD, tenNCC, tenTL, min, max);
	}

	private void giaoDien() {
		setTitle("Quản Lý Băng Đĩa");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1264, 719);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		String[] colName = "Mã Băng Đĩa;Tên Băng Đĩa;Thể Loại;Giá Thuê".split(";");
		tablemodel = new DefaultTableModel(colName, 0);
		JScrollPane scrollPane = new JScrollPane(table = new JTable(tablemodel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(10, 10, 683, 668);
		table.addMouseListener(this);
		contentPane.add(scrollPane);

		// XuatTTCombobox();

		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(703, 10, 541, 668);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		txtGiaChoThue = new JTextField();
		txtGiaChoThue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtGiaChoThue.setBounds(124, 317, 140, 20);
		panel_1.add(txtGiaChoThue);
		txtGiaChoThue.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Chi Tiết Băng Đĩa");
		lblNewLabel_1.setBounds(168, 11, 200, 39);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 23));

		JLabel lblMBnga = new JLabel("Mã Băng Đĩa:");
		lblMBnga.setBounds(27, 95, 87, 22);
		panel_1.add(lblMBnga);
		lblMBnga.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtMaBangDia = new JTextField();
		txtMaBangDia.setEditable(false);
		txtMaBangDia.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtMaBangDia.setBounds(124, 96, 110, 20);
		panel_1.add(txtMaBangDia);
		txtMaBangDia.setColumns(10);

		JLabel lblTnBnga = new JLabel("Tên Băng Đĩa:");
		lblTnBnga.setBounds(27, 149, 94, 22);
		panel_1.add(lblTnBnga);
		lblTnBnga.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtTenBangDia = new JTextField();
		txtTenBangDia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTenBangDia.setBounds(124, 149, 368, 22);
		panel_1.add(txtTenBangDia);
		txtTenBangDia.setColumns(10);

		JLabel lblThLoi = new JLabel("Thể Loại:");
		lblThLoi.setBounds(53, 205, 68, 22);
		panel_1.add(lblThLoi);
		lblThLoi.setFont(new Font("Tahoma", Font.PLAIN, 14));

		cboTheLoai = new JComboBox<String>();
		cboTheLoai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboTheLoai.setBounds(124, 205, 146, 22);
		panel_1.add(cboTheLoai);

		JLabel lblNhCungCp = new JLabel("Nhà Cung Cấp:");
		lblNhCungCp.setBounds(19, 256, 102, 22);
		panel_1.add(lblNhCungCp);
		lblNhCungCp.setFont(new Font("Tahoma", Font.PLAIN, 14));

		cboNCC = new JComboBox<String>();
		cboNCC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboNCC.setBounds(124, 256, 368, 22);
		panel_1.add(cboNCC);

		JLabel lblGiChoThu = new JLabel("Giá Cho Thuê:");
		lblGiChoThu.setBounds(27, 314, 94, 22);
		panel_1.add(lblGiChoThu);
		lblGiChoThu.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblMT = new JLabel("Mô Tả:");
		lblMT.setBounds(67, 363, 54, 22);
		panel_1.add(lblMT);
		lblMT.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel = new JLabel("VND");
		lblNewLabel.setBounds(274, 320, 35, 14);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblSoLuong = new JLabel("Số Lượng :");
		lblSoLuong.setBounds(306, 205, 78, 22);
		panel_1.add(lblSoLuong);
		lblSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtSoLuong = new JTextField();
		txtSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSoLuong.setBounds(382, 205, 110, 22);
		panel_1.add(txtSoLuong);
		txtSoLuong.setColumns(10);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(119, 367, 373, 112);
		panel_1.add(scrollPane_1);

		txaMoTa = new JTextArea();
		scrollPane_1.setViewportView(txaMoTa);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Thanh C\u00F4ng C\u1EE5",

				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 512, 521, 65);
		panel_1.add(panel);

		btnThem = new JButton("Thêm");
		btnThem.setBounds(10, 23, 89, 23);
		panel.add(btnThem);
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 14));

		btnCapNhat = new JButton("Cập Nhật");
		btnCapNhat.setBounds(145, 23, 102, 23);
		panel.add(btnCapNhat);
		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 14));

		btnXoaRong = new JButton("Xóa Rỗng");
		btnXoaRong.setBounds(292, 23, 102, 23);
		panel.add(btnXoaRong);
		btnXoaRong.setFont(new Font("Tahoma", Font.PLAIN, 14));

		btnTroVe = new JButton("Trở Về");
		btnTroVe.setBounds(422, 23, 89, 23);
		panel.add(btnTroVe);
		btnTroVe.setFont(new Font("Tahoma", Font.PLAIN, 14));

		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Thanh T\u00ECm Ki\u1EBFm",

				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 588, 521, 71);
		panel_1.add(panel_2);

		btnXemAll = new JButton("Xem toàn bộ danh sách");
		btnXemAll.setBounds(60, 31, 200, 23);
		panel_2.add(btnXemAll);
		btnXemAll.setFont(new Font("Tahoma", Font.PLAIN, 14));

		btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setBounds(337, 31, 102, 23);
		panel_2.add(btnTimKiem);
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTimKiem.addActionListener(this);
		btnXemAll.addActionListener(this);
		btnTroVe.addActionListener(this);
		btnCapNhat.addActionListener(this);
		btnXoaRong.addActionListener(this);

		btnThem.addActionListener(this);

		XuatTTCombobox();
	}

	private void capNhatBangDuLieu() {
		int rowCount = table.getRowCount();
		for (int i = rowCount; i > 0; i--) {
			tablemodel.removeRow(i - 1);
		}
		BD = new QuanLyBangDia();
		List<BangDia> list = BD.docTuBangBangDia();
		for (BangDia bangDia : list) {
			String[] rowData = { bangDia.getMaBangDia(), bangDia.getTenBangDia(), bangDia.getTheLoai(),
					String.valueOf(bangDia.getGiaThue()) };
			tablemodel.addRow(rowData);
		}
		table.setModel(tablemodel);
	}

	private void dienThongTin(int row) {
		if (row != -1) {
			btnThem.setVisible(false);
			String ma = (String) table.getValueAt(row, 0);
			List<BangDia> listBD = BD.docTuBangBangDia();
			for (BangDia bangDia : listBD) {
				if (ma.trim().equals(bangDia.getMaBangDia().trim())) {
					txtMaBangDia.setEditable(false);
					txtMaBangDia.setText(ma);
					txtTenBangDia.setText(bangDia.getTenBangDia());
					cboTheLoai.setSelectedItem(bangDia.getTheLoai());
					cboNCC.setSelectedItem(bangDia.getNhaCungCap());
					txaMoTa.setText(bangDia.getMoTA());
					txtGiaChoThue.setText(bangDia.getGiaThue() + "");
					txtSoLuong.setText(bangDia.getSoLuong() + "");
				}
			}
		}
	}

	private void XuatTTCombobox() {
		TL = new QuanLyTheLoai();
		NCC = new QuanLyNhaCungCap();
		List<TheLoai> listTL = TL.docTuBang();
		for (TheLoai theLoai : listTL) {
			cboTheLoai.addItem(theLoai.getTenTheLoai());
		}
		List<NhaCungCap> listNCC = NCC.docTuBang();
		for (NhaCungCap nhaCungCap : listNCC) {
			cboNCC.addItem(nhaCungCap.getTenNCC());
		}
	}

	private void XoaRong() {
		btnThem.setVisible(true);
		txtMaBangDia.setText("");
		txtTenBangDia.setText("");
		txtGiaChoThue.setText("");
		txaMoTa.setText("");
		cboNCC.setSelectedIndex(1);
		cboTheLoai.setSelectedIndex(1);
	}

	private void timKiem(String tenBD, String nCC, String theLoai, double min, double max) {
		int rowCount = table.getRowCount();
		for (int i = rowCount; i > 0; i--) {
			tablemodel.removeRow(i - 1);
		}
		BD = new QuanLyBangDia();
		List<BangDia> list = BD.timKiem(tenBD, nCC, theLoai, min, max);
		for (BangDia bangDia : list) {
			String[] rowData = { bangDia.getMaBangDia(), bangDia.getTenBangDia(), bangDia.getTheLoai(),
					String.valueOf(bangDia.getGiaThue()) };
			tablemodel.addRow(rowData);
		}
		table.setModel(tablemodel);
	}

	private boolean kTraDinhDang() {
		String tenBD = txtTenBangDia.getText();
		String soLuong = txtSoLuong.getText();
		String giaThue = txtGiaChoThue.getText();
		if (tenBD.matches("\\s*")) {
			JOptionPane.showMessageDialog(this, "Tên băng đĩa không được để trống!");
			txtTenBangDia.requestFocus();
			txtTenBangDia.selectAll();
			return false;
		} else if (soLuong.matches("\\s*")) {
			JOptionPane.showMessageDialog(this, "Số lượng không được để trống!");
			txtSoLuong.requestFocus();
			txtSoLuong.selectAll();
			return false;
		} else if (giaThue.matches("\\s*")) {
			JOptionPane.showMessageDialog(this, "Giá thuê không được để trống!");
			txtGiaChoThue.requestFocus();
			txtGiaChoThue.selectAll();
			return false;
		} else if (!tenBD.matches("^[\\p{L}0-9 ]+$")) { // Giới hạn kí tự điền vào tên là 2-25 kí tự!
			JOptionPane.showMessageDialog(this, "Vui lòng điền tên chính xác!");
			txtTenBangDia.requestFocus();
			txtTenBangDia.selectAll();
			return false;
		} else if (!soLuong.matches("[0-9]+$")) {
			JOptionPane.showMessageDialog(this, "Số lượng phải là số!");
			txtSoLuong.requestFocus();
			txtSoLuong.selectAll();
			return false;
		} else if (!giaThue.matches("[0-9.]+$")) {
			JOptionPane.showMessageDialog(this, "Giá thuê phải là số !");
			txtGiaChoThue.requestFocus();
			txtGiaChoThue.selectAll();
			return false;
		}
		Double donGia;
		int so;
		donGia = Double.valueOf(txtGiaChoThue.getText());
		so = Integer.valueOf(txtSoLuong.getText());
		if (so < 0) {
			JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn hoặc bằng 0 !");
			txtSoLuong.requestFocus();
			txtSoLuong.selectAll();
			return false;
		}
		if (donGia < 0) {
			JOptionPane.showMessageDialog(this, "Giá thuê phải hơn hoặc bằng 0 !");
			txtGiaChoThue.requestFocus();
			txtGiaChoThue.selectAll();
			return false;
		}
		return true;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			if (kTraDinhDang()) {
				String maBD, tenBD, tenTheLoai, tenNhaCC, moTa;
				Double donGia;
				int soLuong;
				BD = new QuanLyBangDia();
				maBD = BD.tuDongLayMa();
				tenBD = txtTenBangDia.getText();
				tenTheLoai = (String) cboTheLoai.getItemAt(cboTheLoai.getSelectedIndex());
				tenNhaCC = (String) cboNCC.getItemAt(cboNCC.getSelectedIndex());
				moTa = txaMoTa.getText();
				donGia = Double.valueOf(txtGiaChoThue.getText());
				soLuong = Integer.valueOf(txtSoLuong.getText());
				if (BD.themBangDia(maBD, tenBD, moTa, donGia, soLuong, tenTheLoai, tenNhaCC)) {
					capNhatBangDuLieu();
					JOptionPane.showMessageDialog(this, "Thêm thành công");
					XoaRong();
				} else
					JOptionPane.showMessageDialog(this, "Thêm không thành công");
			}
		} else if (o.equals(btnCapNhat)) {
			if (kTraDinhDang()) {
				String maBD, tenBD, tenTheLoai, tenNhaCC, moTa;
				Double donGia;
				int soLuong;
				maBD = txtMaBangDia.getText();
				tenBD = txtTenBangDia.getText();
				tenTheLoai = (String) cboTheLoai.getItemAt(cboTheLoai.getSelectedIndex());
				tenNhaCC = (String) cboNCC.getItemAt(cboNCC.getSelectedIndex());
				moTa = txaMoTa.getText();
				donGia = Double.valueOf(txtGiaChoThue.getText());
				soLuong = Integer.valueOf(txtSoLuong.getText());
				if (BD.capnhat(maBD, tenBD, moTa, donGia, soLuong, tenTheLoai, tenNhaCC)) {
					int rowCount = table.getRowCount();
					for (int i = rowCount; i > 0; i--) {
						tablemodel.removeRow(i - 1);
					}
					capNhatBangDuLieu();
					JOptionPane.showMessageDialog(this, "Cập Nhật thành công");
					XoaRong();
				} else
					JOptionPane.showMessageDialog(this, "Cập nhật không thành công");
			}
		} else if (o.equals(btnTimKiem)) {
			GiaoDienTimKiemBangDia tk = new GiaoDienTimKiemBangDia();
			tk.setVisible(true);
			setVisible(false);
		} else if (o.equals(btnTroVe)) {
			setVisible(false);
		} else if (o.equals(btnXoaRong)) {
			XoaRong();
		} else if (o.equals(btnXemAll)) {
			capNhatBangDuLieu();
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(table)) {
			dienThongTin(table.getSelectedRow());
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
