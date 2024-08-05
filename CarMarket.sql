create database CarMarket1_0
use CarMarket1_0

go


CREATE TABLE Role (
    id int PRIMARY KEY IDENTITY(1,1),
    roleName NVARCHAR(50) NOT NULL
);

-- Tạo bảng Account
CREATE TABLE [Provider] (
    id INT PRIMARY KEY IDENTITY(1,1),
    email NVARCHAR(50) NOT NULL,
    password NVARCHAR(50) NOT NULL,
    role int NOT NULL,
    createDate DATE NOT NULL,
    status BIT NOT NULL,
    CONSTRAINT FK_Account_Role FOREIGN KEY (role) REFERENCES Role(id)
);

-- Tạo bảng User
CREATE TABLE [Client] (
    id INT PRIMARY KEY IDENTITY(1,1),
    firstName NVARCHAR(50) NOT NULL,
    lastName NVARCHAR(50) NOT NULL,
     email NVARCHAR(50) NOT NULL,
	 password NVARCHAR(50) NOT NULL,
    phoneNumber NVARCHAR(10) NOT NULL,
    address NVARCHAR(100) NOT NULL,
    image NVARCHAR(100),
	status BIT NOT NULL,
	createDate DATE NOT NULL,
    
    
);

-- Tạo bảng Feedback
CREATE TABLE Feedback (
    ID INT PRIMARY KEY IDENTITY(1,1),
    note NVARCHAR(50) NOT NULL,
    rank NVARCHAR(50) NOT NULL,
    createDate DATE NOT NULL,
    userId INT NOT NULL,
    CONSTRAINT FK_Feedback_User FOREIGN KEY (userId) REFERENCES Client(id)
);

CREATE TABLE interiorColor (
    InteriorColorID int  PRIMARY KEY IDENTITY(1,1),
    InteriorColorName NVARCHAR(50) NOT NULL
);

CREATE TABLE exteriorColor (
    ExteriorColorID int  PRIMARY KEY IDENTITY(1,1),
    ExteriorColorName NVARCHAR(50) NOT NULL
);

CREATE TABLE numberOfSeats (
    NumberOfSeatsID int  PRIMARY KEY IDENTITY(1,1),
    NumberOfSeatsName NVARCHAR(50) NOT NULL
);

CREATE TABLE numberOfDoors (
    NumberOfDoorsID int  PRIMARY KEY IDENTITY(1,1),
    NumberOfDoorsName NVARCHAR(50) NOT NULL
);

CREATE TABLE engine (
    EngineID int  PRIMARY KEY IDENTITY(1,1),
    EngineName NVARCHAR(50) NOT NULL
);

CREATE TABLE gearbox (
    GearboxID int  PRIMARY KEY IDENTITY(1,1),
    GearboxName NVARCHAR(50) NOT NULL
);

CREATE TABLE origin (
    OriginID int  PRIMARY KEY IDENTITY(1,1),
    OriginName NVARCHAR(50) NOT NULL
);

-- Tạo bảng Post
CREATE TABLE Post (
    id INT PRIMARY KEY IDENTITY(1,1),
    userId INT NOT NULL,
	carId INT NOT NULL,
	carName NVARCHAR(MAX) NOT NULL,
    year DATE NOT NULL,
    originId INT NOT NULL,
    gearboxId INT NOT NULL,
    engineId INT NOT NULL,
    interiorColorId INT NOT NULL,
    exteriorColorId INT NOT NULL,
    numberOfSeatsId INT NOT NULL,
    numberOfDoorsId INT NOT NULL,
	priceCar FLOAT NOT NULL,
    postDate DATE NOT NULL,
    status BIT NOT NULL,
    descriptions NVARCHAR(1000),
    CONSTRAINT FK_Post_User FOREIGN KEY (userId) REFERENCES [Client](id),
	CONSTRAINT FK_Post_Car FOREIGN KEY (carId) REFERENCES [Car](id),
	CONSTRAINT FK_Post_Origin FOREIGN KEY (originId) REFERENCES [origin](OriginID),
	CONSTRAINT FK_Post_Gearbox FOREIGN KEY (gearboxId) REFERENCES [gearbox](GearboxID),
	CONSTRAINT FK_Post_Engine FOREIGN KEY (engineId) REFERENCES [engine](EngineID),
	CONSTRAINT FK_Post_InteriorColor FOREIGN KEY (interiorColorId) REFERENCES [interiorColor](InteriorColorID),
	CONSTRAINT FK_Post_ExteriorColor FOREIGN KEY (exteriorColorId) REFERENCES [exteriorColor](ExteriorColorID),
	CONSTRAINT FK_Post_NumberOfSeats FOREIGN KEY (numberOfSeatsId) REFERENCES [numberOfSeats](NumberOfSeatsID),
	CONSTRAINT FK_Post_NumberOfDoors FOREIGN KEY (numberOfDoorsId) REFERENCES [numberOfDoors](NumberOfDoorsID)
);

CREATE TABLE carImage (
    ImageID int  PRIMARY KEY IDENTITY(1,1),
    postId INT NOT NULL,
	postImg VARCHAR(225)
	CONSTRAINT FK_Post_carImage FOREIGN KEY (postId) REFERENCES [Post](id)
);


-- Tạo bảng Membership
CREATE TABLE Membership (
    id INT PRIMARY KEY IDENTITY(1,1),
    nameShowroom NVARCHAR(50) NOT NULL,
    status BIT NOT NULL,
    startDate DATE NOT NULL,
    endDate DATE NOT NULL,
    membershipType INT NOT NULL,
    userId INT NOT NULL,
    CONSTRAINT FK_Membership_User FOREIGN KEY (userId) REFERENCES [Client](id)
);

-- Tạo bảng SupportRequest
CREATE TABLE SupportRequest (
    id INT PRIMARY KEY IDENTITY(1,1),
    clientId INT NOT NULL,
    message NVARCHAR(MAX) NOT NULL,
    creatDate DATE NOT NULL,
    responseMessage NVARCHAR(MAX) NOT NULL,
    CONSTRAINT FK_SupportRequest_User FOREIGN KEY (clientId) REFERENCES [Client](id)
);

-- Tạo bảng Brand
CREATE TABLE Brand (
    BrandID int  PRIMARY KEY IDENTITY(1,1),
    BrandName NVARCHAR(50) NOT NULL,
	img VARCHAR(225)
);

-- Tạo bảng Model
CREATE TABLE Model (
    ModelID int PRIMARY KEY  IDENTITY(1,1),
    ModelName NVARCHAR(50)  NOT NULL,
	img VARCHAR(225)
);

-- Tạo bảng Car
CREATE TABLE Car (
    id INT PRIMARY KEY IDENTITY(1,1),
    brandId int NOT NULL,
    modelId int NOT NULL,
    userId INT NOT NULL,
    CONSTRAINT FK_Car_Brand FOREIGN KEY (brandId) REFERENCES Brand(BrandID),
    CONSTRAINT FK_Car_Model FOREIGN KEY (modelId) REFERENCES Model(ModelID),
    CONSTRAINT FK_Car_User FOREIGN KEY (userId) REFERENCES [Client](id)
);

-- Tạo bảng Orders
CREATE TABLE Orders (
    ID INT PRIMARY KEY IDENTITY(1,1),
    deposits FLOAT NOT NULL,
    order_date DATE NOT NULL,
    carId INT NOT NULL,
    userId INT NOT NULL,
    CONSTRAINT FK_Orders_Car FOREIGN KEY (carId) REFERENCES Car(id),
    CONSTRAINT FK_Orders_User FOREIGN KEY (userId) REFERENCES [Client](id)
);
