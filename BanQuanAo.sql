CREATE DATABASE QUANLYBANQUANAOTEST;

USE QUANLYBANQUANAOTEST;

CREATE TABLE SANPHAM(
	ID INT AUTO_INCREMENT,
	TEN NVARCHAR(255),
	PRIMARY KEY(ID)
);

CREATE TABLE SIZE(
	ID INT AUTO_INCREMENT,
	TEN NVARCHAR(255),
	PRIMARY KEY(ID)
);

CREATE TABLE NSX(
	ID INT AUTO_INCREMENT,
	TEN NVARCHAR(255),
	PRIMARY KEY(ID)
);

CREATE TABLE DONGSP(
	ID INT AUTO_INCREMENT,
	TEN NVARCHAR(255),
	PRIMARY KEY(ID)
);

CREATE TABLE MAUSAC(
	ID INT AUTO_INCREMENT,
	TEN NVARCHAR(255),
	PRIMARY KEY(ID)
);

CREATE TABLE CHATLIEU(
	ID INT AUTO_INCREMENT,
	TEN NVARCHAR(255),
	PRIMARY KEY(ID)
);

CREATE TABLE CHITIETSP(
	ID INT AUTO_INCREMENT,
	MACTSP NVARCHAR(20) UNIQUE,
	IDSP INT,
	IDDONGSP INT,
	IDMAUSAC INT,
	IDCHATLIEU INT,
	IDSIZE INT,
	IDNSX INT,
	ANH NVARCHAR(255),
	SOLUONGTON INT,
	GIA INT,
	MAVACH INT,
	MOTA NVARCHAR(255),
	PRIMARY KEY(ID),
	FOREIGN KEY(IDSP) REFERENCES SANPHAM(ID),
	FOREIGN KEY(IDDONGSP) REFERENCES DONGSP(ID),
	FOREIGN KEY(IDMAUSAC) REFERENCES MAUSAC(ID),
	FOREIGN KEY(IDCHATLIEU) REFERENCES CHATLIEU(ID),
	FOREIGN KEY(IDSIZE) REFERENCES SIZE(ID),
	FOREIGN KEY(IDNSX) REFERENCES NSX(ID)
);

CREATE TABLE CHUCVU(
	ID INT AUTO_INCREMENT,
	TEN NVARCHAR(255),
	PRIMARY KEY(ID)
);

CREATE TABLE NHANVIEN(
	ID INT AUTO_INCREMENT,
	MANV NVARCHAR(20) UNIQUE,
	CCCD nvarchar(20) unique,
	TEN NVARCHAR(255),
	IDCHUCVU INT,
	GIOITINH BIT,
	NGAYSINH DATE,
	SDT NVARCHAR(10) UNIQUE NOT NULL,
	DIACHI NVARCHAR(255),
	EMAIL NVARCHAR(255) UNIQUE NOT NULL,
	MATKHAU NVARCHAR(255),
	TRANGTHAI BIT,
	PRIMARY KEY(ID),
	FOREIGN KEY(IDCHUCVU) REFERENCES CHUCVU(ID)
);

CREATE TABLE KHUYENMAI(
	ID INT AUTO_INCREMENT,
	MAKHUYENMAI NVARCHAR(20) UNIQUE,
	TEN NVARCHAR(255),
	MUCGIAMGIA INT,
	NGAYBATDAU DATETIME,
	NGAYKETTHUC DATETIME,
	TRANGTHAI INT,
	PRIMARY KEY(ID)
);

CREATE TABLE KHACHHANG(
	ID INT AUTO_INCREMENT,
	MAKHACHHANG NVARCHAR(20) UNIQUE,
	CCCD NVARCHAR(20),
	TEN NVARCHAR(255),
	SDT NVARCHAR(10),
	CAPBAC INT,
	DIACHI NVARCHAR(255),
	PRIMARY KEY(ID)
);

ALTER TABLE KHACHHANG
ADD MATKHAU NVARCHAR(255); 

CREATE TABLE HOADON(
	ID INT AUTO_INCREMENT,
	MAHOADON NVARCHAR(20) UNIQUE,
	IDNHANVIEN INT,
	IDKHACHHANG INT,
	SDT NVARCHAR(10) DEFAULT 'Không có',
	DIACHI NVARCHAR(255),
	HINHTHUCGIAOHANG INT DEFAULT 0,
	HINHTHUCTHANHTOAN INT DEFAULT 0,
	LYDO NVARCHAR(255) DEFAULT 'Không có',
	NGAYSHIP DATE,
	NGAYTHANHTOAN DATE,
	TIENKHACHTRA INT DEFAULT 0,
	TIENKHACHCHUYENKHOAN INT DEFAULT 0,
	NGAYTAO DATE,
	TRANGTHAI INT DEFAULT 0,
	TONGTIEN INT DEFAULT 0,
	IDKHUYENMAI INT DEFAULT 1,
	TIENSAUGIAMGIA INT DEFAULT 0,
	PRIMARY KEY(ID),
	FOREIGN KEY(IDNHANVIEN) REFERENCES NHANVIEN(ID),
	FOREIGN KEY(IDKHUYENMAI) REFERENCES KHUYENMAI(ID),
	FOREIGN KEY(IDKHACHHANG) REFERENCES KHACHHANG(ID)
);

CREATE TABLE HOADONCHITIET(
	ID INT AUTO_INCREMENT,
	IDHOADON INT,
	IDCTSP INT,
	TENSP NVARCHAR(255),
	TENNSX NVARCHAR(255),
	DONGSP NVARCHAR(255),
	MAUSAC NVARCHAR(255),
	ANH NVARCHAR(255),
	SIZE NVARCHAR(255),
	SOLUONG INT,
	DONGIA INT,
	TRANGTHAI INT DEFAULT 0,
	PRIMARY KEY(ID),
	FOREIGN KEY(IDHOADON) REFERENCES HOADON(ID),
	FOREIGN KEY(IDCTSP) REFERENCES CHITIETSP(ID)
);




INSERT INTO SANPHAM VALUES(NULL, 'Quần jeans nam');
INSERT INTO SANPHAM VALUES(NULL, 'Quần shorts nam');
INSERT INTO SANPHAM VALUES(NULL, 'Áo sơ mi nam tay dài');
INSERT INTO SANPHAM VALUES(NULL, 'Quần kaki nam');
INSERT INTO SANPHAM VALUES(NULL, 'Áo khoác nam');
INSERT INTO SANPHAM VALUES(NULL, 'Áo sweater nam');
INSERT INTO SANPHAM VALUES(NULL, 'Áo thun tay dài nam');
INSERT INTO SANPHAM VALUES(NULL, 'Áo khoác jeans nam');
INSERT INTO SANPHAM VALUES(NULL, 'Áo len nam');
INSERT INTO SANPHAM VALUES(NULL, 'Váy kaki');
INSERT INTO SANPHAM VALUES(NULL, 'Áo sơ mi nữ tay dài');
INSERT INTO SANPHAM VALUES(NULL, 'Quần shorts nữ');
INSERT INTO SANPHAM VALUES(NULL, 'Quần jeans nữ');
INSERT INTO SANPHAM VALUES(NULL, 'Áo len nữ');
INSERT INTO SANPHAM VALUES(NULL, 'Áo thun nữ tay ngắn');

INSERT INTO NSX VALUES(NULL, 'NSX1');
INSERT INTO NSX VALUES(NULL, 'NSX2');
INSERT INTO NSX VALUES(NULL, 'NSX3');
INSERT INTO NSX VALUES(NULL, 'NSX4');
INSERT INTO NSX VALUES(NULL, 'NSX5');
INSERT INTO NSX VALUES(NULL, 'NSX6');

INSERT INTO SIZE VALUES(NULL, 'S');
INSERT INTO SIZE VALUES(NULL, 'L');
INSERT INTO SIZE VALUES(NULL, 'XL');
INSERT INTO SIZE VALUES(NULL, 'XXL');

INSERT INTO MAUSAC VALUES(NULL, 'Xanh');
INSERT INTO MAUSAC VALUES(NULL, 'Đỏ');
INSERT INTO MAUSAC VALUES(NULL, 'Vàng');
INSERT INTO MAUSAC VALUES(NULL, 'Tím');
INSERT INTO MAUSAC VALUES(NULL, 'Hồng');
INSERT INTO MAUSAC VALUES(NULL, 'Đen');
INSERT INTO MAUSAC VALUES(NULL, 'Đỏ');
INSERT INTO MAUSAC VALUES(NULL, 'Trắng');
INSERT INTO MAUSAC VALUES(NULL, 'Cam');
INSERT INTO MAUSAC VALUES(NULL, 'Bạc');
INSERT INTO MAUSAC VALUES(NULL, 'Xám');

INSERT INTO DONGSP VALUES(NULL, 'Áo đông');
INSERT INTO DONGSP VALUES(NULL, 'Áo hè');

INSERT INTO CHATLIEU VALUES(NULL, 'Vải Cotton');
INSERT INTO CHATLIEU VALUES(NULL, 'Vải Kaki');
INSERT INTO CHATLIEU VALUES(NULL, 'Vải Kate');
INSERT INTO CHATLIEU VALUES(NULL, 'Vải Jean');
INSERT INTO CHATLIEU VALUES(NULL, 'Vải Nỉ');
INSERT INTO CHATLIEU VALUES(NULL, 'Vải Len');
INSERT INTO CHATLIEU VALUES(NULL, 'Vải Thô (Canvas)');

INSERT INTO CHUCVU VALUES(NULL, 'Quản lý');
INSERT INTO CHUCVU VALUES(NULL, 'Nhân viên');

INSERT INTO NHANVIEN VALUES(NULL, 'NVI1','034203009023',N'Ngô Hoàng Long',1,0,'2003-01-11','0123456789',N'Thái Bình','longnhph27503@fpt.edu.vn',123,0);
INSERT INTO NHANVIEN VALUES(NULL, 'NVI2','000000000000',N'Đoàn Đức Thiện',2,1,'2003-09-02','0987654321',N'Nam Định','thienddph27448@fpt.edu.vn',123,0);

INSERT INTO KHUYENMAI VALUES(NULL, N'KM0',N'Giảm giá ngày 12-12',0,'2022-12-12','2022-12-13',1);
INSERT INTO KHUYENMAI VALUES(NULL, N'KM1',N'Giảm giá ngày 20-12',8,'2022-12-20','2022-12-21',1);
INSERT INTO KHUYENMAI VALUES(NULL, N'KM2',N'Giảm giá thi',12,'2022-12-12','2022-12-16',1);

INSERT INTO KHACHHANG VALUES(NULL, 'KH0','null',N'Khách lẻ','00000000',0,N'Không có');
INSERT INTO KHACHHANG VALUES(NULL, 'KH1','0123456789123',N'Lỗ Chí Thâm','0123456789',0,N'Lương Sơn Bạc','123');
INSERT INTO KHACHHANG VALUES(NULL, 'KH2','1123456789123',N'Võ Tòng','0987654321',0,N'Lương Sơn Bạc','123');
INSERT INTO KHACHHANG VALUES(NULL, 'KH3','2123456789123',N'Tống Giang','0387654321',0,N'Lương Sơn Bạc','123');

INSERT INTO CHITIETSP VALUES(NULL, 'SP1',1,1,1,1,1,1,'img1.png',553,50000,'165875',N'Không có');
INSERT INTO CHITIETSP VALUES(NULL, 'SP2',2,2,2,2,2,2,'img1.png',643,75000,'165875',N'Không có');
INSERT INTO CHITIETSP VALUES(NULL, 'SP3',3,2,3,3,3,3,'img1.png',245,90000,'165875',N'Không có');

INSERT INTO HOADON VALUES(NULL, 'HD154853',1,1,'0684569874',N'89 Lê Đức Thọ-Mỹ Đình',0,0,null,null,'2022-05-12',500000,0,'2022-05-12',1,500000,1,450000);
INSERT INTO HOADON VALUES(NULL, 'HD544677',2,2,'0947658544',N'14 Trần Bình-Cầu Giấy',0,0,null,null,'2022-05-12',300000,0,'2022-05-12',2,300000,1,290000);
INSERT INTO HOADON VALUES(NULL, 'HD734563',2,1,'0947658544',N'17 Trần Bình-Cầu Giấy',1,2,null,'2022-05-12','2022-05-12',0,300000,'2022-05-12',2,300000,1,290000);

INSERT INTO HOADONCHITIET VALUES(2,1,'TESTTENSP0','TESTTENNSX0','TESTDONGSP0','TESTMAUSAC0','TESTANH0','TESTSIZE0',6,99999,1);
INSERT INTO HOADONCHITIET VALUES(3,2,'TESTTENSP1','TESTTENNSX1','TESTDONGSP1','TESTMAUSAC1','TESTANH1','TESTSIZE1',8,88888,1);
INSERT INTO HOADONCHITIET VALUES(1,1,'TESTTENSP2','TESTTENNSX2','TESTDONGSP2','TESTMAUSAC2','TESTANH2','TESTSIZE2',2,55555,1);