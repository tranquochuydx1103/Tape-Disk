package GiaoDien;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DieuKhien.QuanLyNhanVien;
import DieuKhien.QuanLyTaiKhoan;
import DoiTuong.TaiKhoan;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class GiaoDienDangNhap extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtTenTK;
	private JPasswordField pwfMatKhau;
	private JLabel lblTiKhon;
	private JLabel lblMtKhu;
	private JButton btnDangNhap, btnThoat;
	private QuanLyTaiKhoan TK;
	private QuanLyNhanVien NV;
	private JLabel lblngNhp;

	public GiaoDienDangNhap() {
		setTitle("Quản Lý Cửa Hàng Thuê Băng Đĩa");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1014, 572);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(340, 145, 340, 192);
		contentPane.add(panel);
		panel.setLayout(null);

		lblMtKhu = new JLabel("Mật Khẩu :");
		lblMtKhu.setBounds(10, 101, 85, 34);
		panel.add(lblMtKhu);
		lblMtKhu.setFont(new Font("Tahoma", Font.BOLD, 14));

		lblTiKhon = new JLabel("Tài Khoản :");
		lblTiKhon.setBounds(10, 61, 85, 34);
		panel.add(lblTiKhon);
		lblTiKhon.setFont(new Font("Tahoma", Font.BOLD, 14));

		btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.setBounds(65, 146, 108, 25);
		panel.add(btnDangNhap);
		btnDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 14));

		btnThoat = new JButton("Thoát");
		btnThoat.setBounds(216, 146, 95, 25);
		panel.add(btnThoat);
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtTenTK = new JTextField();
		txtTenTK.setBounds(105, 66, 206, 25);
		panel.add(txtTenTK);
		txtTenTK.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTenTK.setColumns(10);

		pwfMatKhau = new JPasswordField();
		pwfMatKhau.setBounds(105, 106, 206, 25);
		panel.add(pwfMatKhau);
		pwfMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(0, 0, 340, 34);
		panel.add(panel_1);
		panel_1.setLayout(null);

		lblngNhp = new JLabel("Đăng Nhập");
		lblngNhp.setHorizontalAlignment(SwingConstants.CENTER);
		lblngNhp.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblngNhp.setBounds(0, 0, 340, 34);
		panel_1.add(lblngNhp);
		pwfMatKhau.addActionListener(this);
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnThoat.addActionListener(this);
		btnDangNhap.addActionListener(this);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/5474953677_e90dfcbb71_b.jpg")));
		lblNewLabel.setBounds(0, 0, 998, 533);
		contentPane.add(lblNewLabel);
	}

	private String kiemTraTK(String tk, String mk) {
		TK = new QuanLyTaiKhoan();
		List<TaiKhoan> list = TK.docTuBang();
		for (TaiKhoan taiKhoan : list) {
			if (tk.equals(taiKhoan.getTenTK()))
				if (mk.equals(taiKhoan.getMatKhau()))
					return taiKhoan.getMaTK().trim();
		}
		return null;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnDangNhap) || o.equals(pwfMatKhau)) {
			String tk = txtTenTK.getText();
			char[] m = pwfMatKhau.getPassword();
			String mk = "";
			for (int i = 0; i < m.length; i++) {
				mk += m[i];
			}
			String ma = kiemTraTK(tk, mk);
			if (ma != null) {
				NV = new QuanLyNhanVien();
				String maNV = NV.layMaNV(ma);
				GiaoDienTong t = new GiaoDienTong(maNV);
				t.setVisible(true);
				setVisible(false);
			} else {
				JOptionPane.showMessageDialog(this, "Sai tên tài khoản hoặc mật khẩu ");
				pwfMatKhau.setText("");
			}
		} else if (o.equals(btnThoat)) {
			setVisible(false);
		}
	}
}
