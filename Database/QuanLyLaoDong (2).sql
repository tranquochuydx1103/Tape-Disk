create database QuanLyLaoDong
go
use QuanLyLaoDong
go
create table PhongBan
(
	IDPhongBan char(5) not null primary key,
	TenPhongBan nvarchar(30) not null
)
go

create table TaiKhoan
(
	IDTaiKhoan char(5) not null primary key,
	TenTK nvarchar(28) not null,
	MatKhau nvarchar(24) not null,
)
go
create table NhanVien
(
	IDNhanVien char(5) not null primary key,
	HoTenNV Nvarchar(40) not null,
	IDPhongBan char(5) not null references PhongBan(IDPhongBan),
	ChucVu nvarchar(30),
	GioiTinh nvarchar(5),
	NgaySinh date,
	NgayLamViec date,
	CMND nvarchar(9) not null,
	DiaChi nvarchar(50),
	Email nvarchar(30),
	SDT nvarchar(15),
	TinhTrang smallint ,
	IDTaiKhoan char(5) not null references TaiKhoan(IDTaiKhoan),
)



go
Create table CongTrinh
(
	IDCongTrinh char(5) not null primary key,
	TenCongTrinh Nvarchar(40) not null,
	DiaDiemCongTrinh Nvarchar(40) not null,
	NgayCapPhepXayDung date ,
	NgayKhoiCong date ,
	NgayHoanThanhTheoDuKien date,
	NgayHoanThanh date,
	TongSoLaoDong int
)
go
create table CongViecCongTrinh(
	IDPhanCong char(5) not null primary key,
	TenCongViec Nvarchar(40) not null,
	NgayBatDau date ,
	NgayKetThuc date ,
	SoLuongLaoDong int,
	IDCongTrinh char(5) references CongTrinh(IDCongTrinh)
)
------------------------------------------------------------------
create table NhanVienThamGiaCongTrinh
(
	IDNhanVien char(5) not null references NhanVien(IDNhanVien),
	IDCongTrinh char(5) not null references CongTrinh(IDCongTrinh),
	primary key (IDNhanVien,IDCongTrinh),
	NgayStart date ,--Ngay bat dau tham gia cong trinh
	NgayEnd date,-- ngay ket thuc tham gia cong trinh
	--ngay cong = NgayEnd - NgayStart

)
go
------------------------------------------------------------------
-- Tự động tăng ID NhanVien
create function TuDongTangIDNhanVien()
returns char(5)
as
	begin
		declare @IDNhanVien char(5)
		declare @SoNhanVien int
		set @SoNhanVien = (select count(NhanVien.IDNhanVien) from NhanVien)
		if (@SoNhanVien=0)
			set @IDNhanVien='NV111'
		else 
			begin
				set @IDNhanVien = RIGHT((select max(NhanVien.IDNhanVien) from NhanVien),3)
				set @SoNhanVien = CAST(@IDNhanVien as int)+1
				set @IDNhanVien = 'NV' + CAST(@SoNhanVien as char(3))
			end
		return @IDNhanVien
	end
go
------------------------------------------------------------------
-- Tự động tăng ID TaiKhoan
create function TuDongTangIDTaiKhoan()
returns char(5)
as
	begin
	declare @IDTaiKhoan char(5)
	declare @SoTaiKhoan int
	set @SoTaiKhoan = (select count(TaiKhoan.IDTaiKhoan) from TaiKhoan)
	if (@SoTaiKhoan=0)
		set @IDTaiKhoan='TK111'
	else 
		begin
			set @IDTaiKhoan = RIGHT((select max(TaiKhoan.IDTaiKhoan) from TaiKhoan),3)
			set @SoTaiKhoan = CAST(@IDTaiKhoan as int)+1
			set @IDTaiKhoan = 'TK' + CAST(@SoTaiKhoan as char(3))
		end
	return @IDTaiKhoan
	end
go

-------------------------------------------------------------------
-- Tự động tăng ID cong trinh
create function TuDongTangIDCongTrinh()
returns char(5)
as
	begin
	declare @IDCongTrinh char(5)
	declare @SoCogTrinh int
	set @SoCogTrinh=(select count([dbo].[CongTrinh].IDCongTrinh) from [dbo].[CongTrinh])
	if(@SoCogTrinh=0)
		begin
			set @SoCogTrinh='CT111'
		end
	else
		begin
			set @IDCongTrinh= RIGHT((select Max([dbo].[CongTrinh].IDCongTrinh) from [dbo].[CongTrinh]),3)
			set @SoCogTrinh= CAST(@SoCogTrinh as int)+1
			set @IDCongTrinh='HD'+CAST(@SoCogTrinh as char(3))
		end

	return @IDCongTrinh
	end
go
-- Tự động tăng ID PhongBan
create function TuDongTangIDPhongBan()
returns char(5)
as
	begin
	declare @IDPhongBan char(5)
	declare @SoPhongBan int
	set @SoPhongBan=(select count([dbo].[PhongBan].IDPhongBan) from [dbo].[PhongBan])
	if(@SoPhongBan=0)
		set @IDPhongBan='PB111'
	else
		begin
			set @IDPhongBan =  RIGHT((select max([dbo].[PhongBan].IDPhongBan) from [dbo].[PhongBan]),3)
			set @SoPhongBan = CAST(@IDPhongBan as int)+1
			set @IDPhongBan = 'CC' + CAST(@SoPhongBan  as char(3))
		end
	return @IDPhongBan
	end
go

-------------------------------------------------------------
insert [dbo].[CongViecCongTrinh] values('PC111',N'Ke toan','5-5-2020','5-5-2021',2,'CT111');
insert [dbo].[CongViecCongTrinh] values('PC112',N'đào móng','5-5-2020','5-5-2021',1,'CT111');
insert [dbo].[CongViecCongTrinh] values('PC113',N'Thiết kế nhà','5-5-2020','5-10-2021',1,'CT111');
go

insert [dbo].[CongTrinh] values('CT111',N'BITEXCO',N'Qua 1','6-6-2020','7-6-2020','7-6-2022',null,10);
go




