# Host: localhost  (Version 5.5.28)
# Date: 2018-10-16 15:09:28
# Generator: MySQL-Front 6.1  (Build 1.21)


#
# Structure for table "address"
#

DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `state` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `zip_code` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "address"
#


#
# Structure for table "announcement"
#

DROP TABLE IF EXISTS `announcement`;
CREATE TABLE `announcement` (
  `id` int(11) NOT NULL,
  `title` varchar(45) DEFAULT NULL,
  `avaliability` varchar(45) DEFAULT NULL,
  `durationType` varchar(45) DEFAULT NULL,
  `durationstart` date DEFAULT NULL,
  `durationend` date DEFAULT NULL,
  `loginDetails` varchar(45) DEFAULT NULL,
  `loginCourseDetails` varchar(45) DEFAULT NULL,
  `created` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "announcement"
#

INSERT INTO `announcement` VALUES (1,'sale','1','permanent','2018-02-01','2018-03-04','true','true','2018-10-15');

#
# Structure for table "assessment"
#

DROP TABLE IF EXISTS `assessment`;
CREATE TABLE `assessment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `text` varchar(45) DEFAULT NULL,
  `points` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `instructorNotes` varchar(45) DEFAULT NULL,
  `feedback` varchar(45) DEFAULT NULL,
  `questions` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "assessment"
#

INSERT INTO `assessment` VALUES (1,'assessment1','notes','10','presentation','yes','required',NULL);

#
# Structure for table "authors"
#

DROP TABLE IF EXISTS `authors`;
CREATE TABLE `authors` (
  `authId` int(11) NOT NULL AUTO_INCREMENT,
  `First_Name` varchar(120) DEFAULT NULL,
  `Last_Name` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`authId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

#
# Data for table "authors"
#

INSERT INTO `authors` VALUES (4,'James','James clerk'),(5,'AK','AKk');

#
# Structure for table "book_categories"
#

DROP TABLE IF EXISTS `book_categories`;
CREATE TABLE `book_categories` (
  `catId` bigint(11) NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(120) DEFAULT NULL,
  `campusId` int(20) DEFAULT NULL,
  PRIMARY KEY (`catId`),
  KEY `fk_campusId_idx` (`campusId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

#
# Data for table "book_categories"
#

INSERT INTO `book_categories` VALUES (3,'English',4),(4,'Engineering',7);

#
# Structure for table "books"
#

DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ISBN` varchar(45) NOT NULL,
  `Book_title` varchar(120) NOT NULL,
  `date_of_publication` date NOT NULL,
  `totalBooks` int(11) NOT NULL,
  `availableBooks` int(11) DEFAULT NULL,
  `campusId` bigint(20) NOT NULL,
  `categoryId` bigint(20) DEFAULT NULL,
  `bookCount` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

#
# Data for table "books"
#

INSERT INTO `books` VALUES (4,'123','English','2000-05-31',12,12,4,3,NULL),(5,'12564','M one','2000-06-07',5,4,7,4,NULL);

#
# Structure for table "books_authors_mapping"
#

DROP TABLE IF EXISTS `books_authors_mapping`;
CREATE TABLE `books_authors_mapping` (
  `Books_id` int(11) NOT NULL,
  `Authors_id` int(11) NOT NULL,
  PRIMARY KEY (`Books_id`,`Authors_id`),
  KEY `fk_Books_has_Authors_Authors1_idx` (`Authors_id`),
  KEY `fk_Books_has_Authors_Books1_idx` (`Books_id`),
  CONSTRAINT `fk_Books_has_Authors_Authors1` FOREIGN KEY (`Authors_id`) REFERENCES `authors` (`authId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Books_has_Authors_Books1` FOREIGN KEY (`Books_id`) REFERENCES `books` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "books_authors_mapping"
#

INSERT INTO `books_authors_mapping` VALUES (4,4),(5,5);

#
# Structure for table "books_book_categories_mapping"
#

DROP TABLE IF EXISTS `books_book_categories_mapping`;
CREATE TABLE `books_book_categories_mapping` (
  `Books_id` int(11) NOT NULL,
  `Book_Categories_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "books_book_categories_mapping"
#

INSERT INTO `books_book_categories_mapping` VALUES (4,3),(5,4);

#
# Structure for table "busdetails"
#

DROP TABLE IF EXISTS `busdetails`;
CREATE TABLE `busdetails` (
  `busDetails_id` int(11) NOT NULL,
  `route_Num` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`busDetails_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "busdetails"
#

INSERT INTO `busdetails` VALUES (12,'13');

#
# Structure for table "calendar"
#

DROP TABLE IF EXISTS `calendar`;
CREATE TABLE `calendar` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "calendar"
#

INSERT INTO `calendar` VALUES (1,'Holidays'),(2,'Meetings'),(3,'Course');

#
# Structure for table "calendaritems"
#

DROP TABLE IF EXISTS `calendaritems`;
CREATE TABLE `calendaritems` (
  `id` int(11) NOT NULL,
  `type` varchar(45) DEFAULT NULL,
  `calendarId` int(11) DEFAULT NULL,
  `calendarName` varchar(45) DEFAULT NULL,
  `title` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `location` varchar(45) DEFAULT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `modified` date DEFAULT NULL,
  `color` varchar(45) DEFAULT NULL,
  `categoryId` varchar(45) DEFAULT NULL,
  `eventtype` varchar(45) DEFAULT NULL,
  `frequency` varchar(45) DEFAULT NULL,
  `interval` varchar(45) DEFAULT NULL,
  `monthRepeatday` varchar(45) DEFAULT NULL,
  `monthposition` varchar(45) DEFAULT NULL,
  `originalstart` date DEFAULT NULL,
  `originalend` date DEFAULT NULL,
  `repeatDay` varchar(45) DEFAULT NULL,
  `until` date DEFAULT NULL,
  `weekDays` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `forrignkey_courseId_idx` (`calendarId`),
  CONSTRAINT `forrignkey_courseId` FOREIGN KEY (`calendarId`) REFERENCES `calendar` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "calendaritems"
#

INSERT INTO `calendaritems` VALUES (1,'institution',1,'Holidays','InstitutionCalendar','list the holidays','gulbarg','2018-04-03','2018-03-03','2018-02-03','black','1','Official','1','1','1','1',NULL,'2018-02-01','1','2018-02-02','7');

#
# Structure for table "category"
#

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `categoryId` int(11) NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`categoryId`),
  UNIQUE KEY `categoryName_UNIQUE` (`categoryName`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

#
# Data for table "category"
#

INSERT INTO `category` VALUES (1,'SC'),(2,'ST'),(3,'Cat-1'),(4,'2A'),(5,'2B'),(6,'3A'),(7,'3B'),(8,'GM');

#
# Structure for table "classtimetable"
#

DROP TABLE IF EXISTS `classtimetable`;
CREATE TABLE `classtimetable` (
  `TtId` int(11) NOT NULL AUTO_INCREMENT,
  `classId` int(11) DEFAULT NULL,
  `endTime` varchar(255) DEFAULT NULL,
  `sectionId` int(11) DEFAULT NULL,
  `startTime` varchar(255) DEFAULT NULL,
  `subjectName` varchar(255) DEFAULT NULL,
  `weekDayId` int(11) DEFAULT NULL,
  PRIMARY KEY (`TtId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "classtimetable"
#


#
# Structure for table "context"
#

DROP TABLE IF EXISTS `context`;
CREATE TABLE `context` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `context` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

#
# Data for table "context"
#

INSERT INTO `context` VALUES (1,'sys_admin'),(2,'org_admin'),(3,'campus_admin'),(4,'student'),(5,'staff'),(6,'parent/guardian'),(7,'publisher'),(8,'librarian'),(9,'Driver');

#
# Structure for table "country"
#

DROP TABLE IF EXISTS `country`;
CREATE TABLE `country` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `countryname` varchar(200) DEFAULT NULL,
  `createdat` date DEFAULT NULL,
  `updatedat` date DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "country"
#


#
# Structure for table "courseassesment"
#

DROP TABLE IF EXISTS `courseassesment`;
CREATE TABLE `courseassesment` (
  `courseId` int(11) NOT NULL,
  `assessmentId` int(11) NOT NULL,
  `title` varchar(45) DEFAULT NULL,
  `points` varchar(45) DEFAULT NULL,
  `instructorNotes` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `courseassesmentcol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`courseId`,`assessmentId`),
  KEY `foreignkey_courseId_idx` (`courseId`),
  KEY `foreignkey__idx` (`assessmentId`),
  CONSTRAINT `foreignkey_assessmentId` FOREIGN KEY (`assessmentId`) REFERENCES `assessment` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `foreignkey_courseId` FOREIGN KEY (`courseId`) REFERENCES `assessment` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "courseassesment"
#

INSERT INTO `courseassesment` VALUES (1,1,'CourseTest','10','Yes','PPT',NULL);

#
# Structure for table "courseassessment"
#

DROP TABLE IF EXISTS `courseassessment`;
CREATE TABLE `courseassessment` (
  `courseId` int(11) NOT NULL,
  `assessmentId` int(11) DEFAULT NULL,
  `instructorNotes` varchar(255) DEFAULT NULL,
  `points` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`courseId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "courseassessment"
#


#
# Structure for table "coursebkp"
#

DROP TABLE IF EXISTS `coursebkp`;
CREATE TABLE `coursebkp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `allowGuests` varchar(255) DEFAULT NULL,
  `availibility` varchar(255) DEFAULT NULL,
  `courseId` int(11) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `dataSourceId` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `enrollment` varchar(255) DEFAULT NULL,
  `externalId` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `organization` varchar(255) DEFAULT NULL,
  `readOnly` varchar(255) DEFAULT NULL,
  `termId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "coursebkp"
#


#
# Structure for table "blackboardterms"
#

DROP TABLE IF EXISTS `blackboardterms`;
CREATE TABLE `blackboardterms` (
  `id` int(11) NOT NULL,
  `externalId` varchar(45) DEFAULT NULL,
  `dataSourceId` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `availability` varchar(45) DEFAULT NULL,
  `durationtype` varchar(45) DEFAULT NULL,
  `durationstart` date DEFAULT NULL,
  `durationend` date DEFAULT NULL,
  `durationDaysOfUse` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `foreignky_Id_idx` (`id`),
  CONSTRAINT `foreignky_Id` FOREIGN KEY (`id`) REFERENCES `coursetable` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "blackboardterms"
#

INSERT INTO `blackboardterms` VALUES (1,'1','1','course1','technology','yes','mid','2018-03-03','2018-03-04','90');

#
# Structure for table "coursetable"
#

DROP TABLE IF EXISTS `coursetable`;
CREATE TABLE `coursetable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `courseId` int(11) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `organization` varchar(45) DEFAULT NULL,
  `readOnly` varchar(45) DEFAULT NULL,
  `termId` int(11) DEFAULT NULL,
  `availability` varchar(45) DEFAULT NULL,
  `enrollment` varchar(45) DEFAULT NULL,
  `dataSourceId` varchar(45) DEFAULT NULL,
  `externalId` varchar(45) DEFAULT NULL,
  `created` date DEFAULT NULL,
  `allowGuests` varchar(45) DEFAULT NULL,
  `availibility` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `foreignkey_ID_idx` (`termId`),
  CONSTRAINT `foreignkey_ID` FOREIGN KEY (`termId`) REFERENCES `blackboardterms` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Data for table "coursetable"
#

INSERT INTO `coursetable` VALUES (1,1,'a','a','a','y',1,'y','y','1','1','2018-01-01','y',NULL),(2,5,'abc','xyz',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,4,'abc','xyz',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

#
# Structure for table "coursegrades"
#

DROP TABLE IF EXISTS `coursegrades`;
CREATE TABLE `coursegrades` (
  `courseId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `externalGrade` varchar(45) DEFAULT NULL,
  `contentId` varchar(45) DEFAULT NULL,
  `score` varchar(45) DEFAULT NULL,
  `gradingtype` varchar(45) DEFAULT NULL,
  `gradingdue` varchar(45) DEFAULT NULL,
  `gradingattemptsAllowed` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`courseId`),
  KEY `foreignky_CourseId_idx` (`courseId`),
  CONSTRAINT `foreignky_CourseId` FOREIGN KEY (`courseId`) REFERENCES `coursetable` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "coursegrades"
#

INSERT INTO `coursegrades` VALUES (1,'test','test','true','abc123','10','attempts','2018/10/5','0');

#
# Structure for table "driver_details"
#

DROP TABLE IF EXISTS `driver_details`;
CREATE TABLE `driver_details` (
  `dId` bigint(20) NOT NULL AUTO_INCREMENT,
  `DLno` varchar(45) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `vehicleId` int(11) DEFAULT NULL,
  `documentsSubmitted` varchar(200) DEFAULT NULL,
  `religionId` int(11) DEFAULT NULL,
  `motherTongueId` int(11) DEFAULT NULL,
  `categoryId` int(11) DEFAULT NULL,
  `nationalityId` int(11) DEFAULT NULL,
  `campusId` int(11) DEFAULT NULL,
  PRIMARY KEY (`dId`),
  KEY `FK_Vehicle_idx` (`vehicleId`),
  CONSTRAINT `FK_Vehicle` FOREIGN KEY (`vehicleId`) REFERENCES `vehicle_details` (`vdId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

#
# Data for table "driver_details"
#

INSERT INTO `driver_details` VALUES (2,'56',11,2,'SSLC',2,2,5,1,4),(3,'5645',12,2,'SSLC',2,2,5,1,4),(4,'564556',13,3,'SSLC',2,2,5,1,4),(5,'123456',14,3,'SSLC',2,2,5,1,7),(6,'DL8862',19,4,'DL',1,1,1,1,7);

#
# Structure for table "event"
#

DROP TABLE IF EXISTS `event`;
CREATE TABLE `event` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `campusId` int(11) NOT NULL,
  `endDate` varchar(255) DEFAULT NULL,
  `evId` int(11) NOT NULL,
  `startDate` varchar(255) DEFAULT NULL,
  `studUserId` int(11) NOT NULL,
  `eId` int(11) NOT NULL,
  `studentUserId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "event"
#


#
# Structure for table "events_details"
#

DROP TABLE IF EXISTS `events_details`;
CREATE TABLE `events_details` (
  `eId` bigint(15) NOT NULL AUTO_INCREMENT,
  `evId` bigint(20) DEFAULT NULL,
  `studentUserId` bigint(15) DEFAULT NULL,
  `campusId` bigint(20) NOT NULL,
  `messageFlag` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`eId`),
  KEY `fk_studuserId_fk_idx` (`studentUserId`),
  KEY `fk_event_id_idx` (`evId`),
  CONSTRAINT `fk_event_id` FOREIGN KEY (`evId`) REFERENCES `events_master` (`evId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_studuserId_fk` FOREIGN KEY (`studentUserId`) REFERENCES `student_details` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "events_details"
#

INSERT INTO `events_details` VALUES (1,2,5,4,0);

#
# Structure for table "events_master"
#

DROP TABLE IF EXISTS `events_master`;
CREATE TABLE `events_master` (
  `evId` bigint(15) NOT NULL AUTO_INCREMENT,
  `eventName` varchar(100) DEFAULT NULL,
  `eventDescription` varchar(500) DEFAULT NULL,
  `campusId` bigint(15) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `startDate` date DEFAULT NULL,
  `endDate` date DEFAULT NULL,
  PRIMARY KEY (`evId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Data for table "events_master"
#

INSERT INTO `events_master` VALUES (2,'Fancy Dress','Fancy Dress',4,0,'2017-08-08','2017-08-10');

#
# Structure for table "exam_class_mapping"
#

DROP TABLE IF EXISTS `exam_class_mapping`;
CREATE TABLE `exam_class_mapping` (
  `ecmId` bigint(11) NOT NULL AUTO_INCREMENT,
  `examId` bigint(1) DEFAULT NULL,
  `classId` bigint(1) DEFAULT NULL,
  `sectionId` bigint(20) DEFAULT NULL,
  `termId` bigint(1) DEFAULT NULL,
  `createdAt` date DEFAULT NULL,
  `updateAt` date DEFAULT NULL,
  PRIMARY KEY (`ecmId`),
  KEY `FK_exmClsMap_idx` (`sectionId`),
  CONSTRAINT `FK_exmClsMap` FOREIGN KEY (`sectionId`) REFERENCES `section` (`sectionId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Data for table "exam_class_mapping"
#

INSERT INTO `exam_class_mapping` VALUES (2,2,4,2,3,'2017-08-03','2017-08-03'),(3,2,5,5,3,'2017-08-03','2017-08-03');

#
# Structure for table "exam_master"
#

DROP TABLE IF EXISTS `exam_master`;
CREATE TABLE `exam_master` (
  `examId` bigint(11) NOT NULL AUTO_INCREMENT,
  `examName` varchar(255) DEFAULT NULL,
  `createAt` date DEFAULT NULL,
  `updateAt` date DEFAULT NULL,
  `campusId` int(11) DEFAULT NULL,
  PRIMARY KEY (`examId`),
  UNIQUE KEY `examName_UNIQUE` (`examName`),
  KEY `examMaster_campus_idx` (`campusId`),
  CONSTRAINT `examMaster_campus` FOREIGN KEY (`campusId`) REFERENCES `campus` (`cmId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Data for table "exam_master"
#

INSERT INTO `exam_master` VALUES (2,'test2','2017-08-03','2017-08-03',4);

#
# Structure for table "examclassmapping"
#

DROP TABLE IF EXISTS `examclassmapping`;
CREATE TABLE `examclassmapping` (
  `ecmId` int(11) NOT NULL AUTO_INCREMENT,
  `classId` int(11) DEFAULT NULL,
  `createdAt` datetime DEFAULT NULL,
  `examId` int(11) DEFAULT NULL,
  `sectionId` int(11) DEFAULT NULL,
  `termId` int(11) DEFAULT NULL,
  `updatedAt` datetime DEFAULT NULL,
  PRIMARY KEY (`ecmId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "examclassmapping"
#

INSERT INTO `examclassmapping` VALUES (1,1,'2018-01-01 00:00:00',1,1,1,'2018-10-05 00:00:00');

#
# Structure for table "examdetails"
#

DROP TABLE IF EXISTS `examdetails`;
CREATE TABLE `examdetails` (
  `EttId` int(11) NOT NULL AUTO_INCREMENT,
  `createdAt` datetime DEFAULT NULL,
  `ecmapId` varchar(255) DEFAULT NULL,
  `examDate` varchar(255) DEFAULT NULL,
  `fromTime` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `subId` int(11) DEFAULT NULL,
  `toTime` int(11) DEFAULT NULL,
  `updatedAt` datetime DEFAULT NULL,
  PRIMARY KEY (`EttId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "examdetails"
#


#
# Structure for table "examtimetable"
#

DROP TABLE IF EXISTS `examtimetable`;
CREATE TABLE `examtimetable` (
  `EttId` bigint(11) NOT NULL AUTO_INCREMENT,
  `subId` bigint(11) DEFAULT NULL,
  `ecmapId` bigint(20) DEFAULT NULL,
  `examDate` date DEFAULT NULL,
  `fromTime` varchar(30) DEFAULT NULL,
  `toTime` varchar(30) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `createdAt` date DEFAULT NULL,
  `updatedAt` date DEFAULT NULL,
  PRIMARY KEY (`EttId`),
  KEY `Subject_Id_idx` (`subId`),
  KEY `classmapping_id_idx` (`ecmapId`),
  CONSTRAINT `classmapping_id` FOREIGN KEY (`ecmapId`) REFERENCES `exam_class_mapping` (`ecmId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Subject_Id` FOREIGN KEY (`subId`) REFERENCES `subject_master` (`subId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

#
# Data for table "examtimetable"
#

INSERT INTO `examtimetable` VALUES (1,6,2,'2017-08-01','09:00 AM','01:30 PM',1,'2017-08-23','2017-08-23'),(2,7,2,'2017-08-02','09:00 AM','01:30 PM',1,'2017-08-23','2017-08-23'),(3,8,2,'2017-08-03','09:00 AM','01:30 PM',1,'2017-08-23','2017-08-23'),(4,9,2,'2017-08-04','09:00 AM','01:30 PM',1,'2017-08-23','2017-08-23');

#
# Structure for table "feedates"
#

DROP TABLE IF EXISTS `feedates`;
CREATE TABLE `feedates` (
  `feeDatesId` int(11) NOT NULL AUTO_INCREMENT,
  `feeTypeId` int(11) DEFAULT NULL,
  `feeStartDate` varchar(45) DEFAULT NULL,
  `feeEndDate` varchar(45) DEFAULT NULL,
  `feeDueDate` varchar(45) DEFAULT NULL,
  `fineAmount` int(11) DEFAULT NULL,
  PRIMARY KEY (`feeDatesId`),
  KEY `fk_feeType_feeDatesTypeId_idx` (`feeTypeId`),
  CONSTRAINT `fk_feeType_feeDatesTypeId` FOREIGN KEY (`feeTypeId`) REFERENCES `feetype` (`feeTypeId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "feedates"
#

INSERT INTO `feedates` VALUES (1,1,'06/05/2018','25/05/2018','28/05/2018',300);

#
# Structure for table "feepay"
#

DROP TABLE IF EXISTS `feepay`;
CREATE TABLE `feepay` (
  `feePayId` int(11) NOT NULL AUTO_INCREMENT,
  `studentUserId` bigint(12) NOT NULL DEFAULT '0',
  `challanNumber` bigint(15) DEFAULT NULL,
  `feeTypeId` int(11) NOT NULL DEFAULT '0',
  `amountPaid` bigint(12) NOT NULL DEFAULT '0',
  `balance` bigint(12) NOT NULL DEFAULT '0',
  `createdAt` datetime DEFAULT NULL,
  `updatedAt` datetime DEFAULT NULL,
  PRIMARY KEY (`feePayId`),
  KEY `studentDetail_feePayStdUserId_idx` (`studentUserId`),
  KEY `feeType_feePayFeeTypeId_idx` (`feeTypeId`),
  CONSTRAINT `feeType_feePayFeeTypeId` FOREIGN KEY (`feeTypeId`) REFERENCES `feetype` (`feeTypeId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `studentDetail_feePayStdUserId` FOREIGN KEY (`studentUserId`) REFERENCES `student_details` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "feepay"
#

INSERT INTO `feepay` VALUES (1,5,54321,1,1800,200,'2018-06-05 16:44:04','2018-06-05 16:44:04');

#
# Structure for table "feesdetail"
#

DROP TABLE IF EXISTS `feesdetail`;
CREATE TABLE `feesdetail` (
  `feesDetailId` int(11) NOT NULL AUTO_INCREMENT,
  `feeDetailName` varchar(60) DEFAULT NULL,
  `campusId` int(11) DEFAULT NULL,
  `feeDetailId` int(11) NOT NULL,
  PRIMARY KEY (`feesDetailId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "feesdetail"
#

INSERT INTO `feesdetail` VALUES (1,'Sports',4,0);

#
# Structure for table "feesdetailclassmap"
#

DROP TABLE IF EXISTS `feesdetailclassmap`;
CREATE TABLE `feesdetailclassmap` (
  `feesDetailClassMapId` int(11) NOT NULL AUTO_INCREMENT,
  `feesDetailId` int(11) DEFAULT NULL,
  `classId` bigint(12) DEFAULT NULL,
  `sectionId` bigint(12) DEFAULT NULL,
  `amount` bigint(12) DEFAULT NULL,
  PRIMARY KEY (`feesDetailClassMapId`),
  KEY `FK_feesDetailId_idx` (`feesDetailId`),
  KEY `FK_classId_idx` (`classId`),
  KEY `FK_sectionId_idx` (`sectionId`),
  CONSTRAINT `FK_classId` FOREIGN KEY (`classId`) REFERENCES `class` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_feesDetailId` FOREIGN KEY (`feesDetailId`) REFERENCES `feesdetail` (`feesDetailId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_sectionId` FOREIGN KEY (`sectionId`) REFERENCES `section` (`sectionId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "feesdetailclassmap"
#

INSERT INTO `feesdetailclassmap` VALUES (1,1,4,2,2000);

#
# Structure for table "feetype"
#

DROP TABLE IF EXISTS `feetype`;
CREATE TABLE `feetype` (
  `feeTypeId` int(11) NOT NULL AUTO_INCREMENT,
  `feeTypeName` varchar(60) DEFAULT NULL,
  `feeCount` int(11) DEFAULT NULL,
  `campusId` int(11) DEFAULT NULL,
  `feesDetailClassMapId` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `classId` int(11) NOT NULL,
  `feesDetailId` int(11) NOT NULL,
  `sectionId` int(11) NOT NULL,
  PRIMARY KEY (`feeTypeId`),
  KEY `fk_campusId_idx` (`campusId`),
  CONSTRAINT `FK_campus_feeClsMapCampusId` FOREIGN KEY (`campusId`) REFERENCES `campus` (`cmId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "feetype"
#

INSERT INTO `feetype` VALUES (1,'Offline',1,4,0,0,0,0,0);

#
# Structure for table "guardian"
#

DROP TABLE IF EXISTS `guardian`;
CREATE TABLE `guardian` (
  `gId` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `relationship` varchar(100) DEFAULT NULL,
  `mobile` bigint(20) DEFAULT NULL,
  `income` varchar(100) DEFAULT NULL,
  `education` varchar(100) DEFAULT NULL,
  `occupation` varchar(60) DEFAULT NULL,
  `stdadmissionno` varchar(200) DEFAULT NULL,
  `documentsSubmitted` varchar(200) DEFAULT NULL,
  `religionId` int(11) DEFAULT NULL,
  `motherTongueId` int(11) DEFAULT NULL,
  `categoryId` int(11) DEFAULT NULL,
  `nationalityId` int(11) DEFAULT NULL,
  PRIMARY KEY (`gId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Data for table "guardian"
#

INSERT INTO `guardian` VALUES (2,9,'father',122,'7890','Business','BCom','adm01,adm04','no',2,2,8,1),(3,22,'son',122,'10','se','it','A0889','exp',1,1,3,1);

#
# Structure for table "hibernate_sequence"
#

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "hibernate_sequence"
#

INSERT INTO `hibernate_sequence` VALUES (17),(17),(17),(17),(17),(17),(17);

#
# Structure for table "holidaylist"
#

DROP TABLE IF EXISTS `holidaylist`;
CREATE TABLE `holidaylist` (
  `hId` int(11) NOT NULL,
  `campusId` varchar(255) DEFAULT NULL,
  `holidayDesc` varchar(255) DEFAULT NULL,
  `holidayEndDate` varchar(255) DEFAULT NULL,
  `holidayName` varchar(255) DEFAULT NULL,
  `holidayStartDate` varchar(255) DEFAULT NULL,
  `messageFlag` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`hId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "holidaylist"
#


#
# Structure for table "holidays"
#

DROP TABLE IF EXISTS `holidays`;
CREATE TABLE `holidays` (
  `hId` bigint(15) NOT NULL AUTO_INCREMENT,
  `holidayName` varchar(200) DEFAULT NULL,
  `holidayDesc` varchar(1000) DEFAULT NULL,
  `campusId` bigint(20) DEFAULT NULL,
  `messageFlag` tinyint(4) DEFAULT NULL,
  `holidayStartDate` date DEFAULT NULL,
  `holidayEndDate` date DEFAULT NULL,
  PRIMARY KEY (`hId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Data for table "holidays"
#

INSERT INTO `holidays` VALUES (3,'Holi','Colors',4,0,'2017-03-07','2017-03-09');

#
# Structure for table "librarian"
#

DROP TABLE IF EXISTS `librarian`;
CREATE TABLE `librarian` (
  `libId` int(11) NOT NULL AUTO_INCREMENT,
  `user_Id` bigint(20) DEFAULT NULL,
  `libUniqueId` bigint(20) DEFAULT NULL,
  `documentsSubmitted` varchar(200) DEFAULT NULL,
  `religionId` int(11) DEFAULT NULL,
  `motherTongueId` int(11) DEFAULT NULL,
  `categoryId` int(11) DEFAULT NULL,
  `nationalityId` int(11) DEFAULT NULL,
  PRIMARY KEY (`libId`),
  KEY `Foreignky_usercontext_idx` (`user_Id`),
  CONSTRAINT `Foreignky_usercontext` FOREIGN KEY (`user_Id`) REFERENCES `user_context` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Data for table "librarian"
#

INSERT INTO `librarian` VALUES (1,10,1,'no',2,2,3,1),(2,23,1,'exp',1,1,1,1);

#
# Structure for table "books_issued"
#

DROP TABLE IF EXISTS `books_issued`;
CREATE TABLE `books_issued` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) DEFAULT NULL,
  `bookid` int(11) DEFAULT NULL,
  `date_issued` date DEFAULT NULL,
  `date_due_for_return` date DEFAULT NULL,
  `date_returned` date DEFAULT NULL,
  `amount_of_fine` int(11) DEFAULT NULL,
  `libUserId` bigint(20) DEFAULT NULL,
  `bookReturnFlag` tinyint(4) DEFAULT NULL,
  `libRetId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Books_Books_issue_idx` (`bookid`),
  KEY `Fk_Librarian_UserId_idx` (`libUserId`),
  CONSTRAINT `FK_Books_Books_issue` FOREIGN KEY (`bookid`) REFERENCES `books` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Fk_Librarian_UserId` FOREIGN KEY (`libUserId`) REFERENCES `librarian` (`user_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Data for table "books_issued"
#

INSERT INTO `books_issued` VALUES (1,3,4,'2017-08-09','2017-08-10',NULL,0,10,1,0),(2,17,5,'2017-09-06','2017-09-13',NULL,0,23,1,0),(3,6,4,'2017-09-07','2017-09-09',NULL,0,10,1,0);

#
# Structure for table "login"
#

DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `id` int(11) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "login"
#

INSERT INTO `login` VALUES (1,'minds','minds'),(2,'test','test');

#
# Structure for table "marks"
#

DROP TABLE IF EXISTS `marks`;
CREATE TABLE `marks` (
  `mId` bigint(11) NOT NULL AUTO_INCREMENT,
  `ecmId` bigint(11) DEFAULT NULL,
  `userId` bigint(11) DEFAULT NULL,
  `subjectId` bigint(11) DEFAULT NULL,
  `maxMarks` bigint(11) DEFAULT NULL,
  `minMarks` bigint(11) DEFAULT NULL,
  `marksObtained` bigint(11) DEFAULT NULL,
  `marksInWords` varchar(100) DEFAULT NULL,
  `remarks` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`mId`),
  KEY `Exam_class_Id_idx` (`ecmId`),
  KEY `stud_user_Id_idx` (`userId`),
  KEY `sub_Id_idx` (`subjectId`),
  CONSTRAINT `Exam_class_Id` FOREIGN KEY (`ecmId`) REFERENCES `exam_class_mapping` (`ecmId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `stud_user_Id` FOREIGN KEY (`userId`) REFERENCES `student_details` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `sub_Id` FOREIGN KEY (`subjectId`) REFERENCES `subject_master` (`subId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

#
# Data for table "marks"
#

INSERT INTO `marks` VALUES (2,2,5,6,100,45,80,'eighty','Pass'),(3,2,6,6,100,45,88,'eighty eight','Pass'),(4,2,5,7,100,45,90,'ninty','Pass'),(5,2,6,7,100,45,90,'ninty','Pass'),(6,2,5,8,100,45,70,'seventy','Pass'),(7,2,6,8,100,45,70,'seventy','Pass'),(8,2,5,9,100,45,65,'sixty five','Pass'),(9,2,6,9,100,45,65,'sixty five','Pass');

#
# Structure for table "mastertimetable"
#

DROP TABLE IF EXISTS `mastertimetable`;
CREATE TABLE `mastertimetable` (
  `mttId` int(11) NOT NULL AUTO_INCREMENT,
  `campusId` int(11) DEFAULT NULL,
  `periods` int(11) DEFAULT NULL,
  `startDay` varchar(45) DEFAULT NULL,
  `endDay` varchar(45) DEFAULT NULL,
  `morningSessionBreak` int(11) DEFAULT NULL,
  `afterNoonSessionBreak` int(11) DEFAULT NULL,
  `lunchBreak` int(11) DEFAULT NULL,
  `morningSessionBreakFast` tinyint(4) DEFAULT NULL,
  `afterNoonSessionBreakFast` tinyint(4) DEFAULT NULL,
  `lunchBreakFast` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`mttId`),
  KEY `FK_masterTimeTable_campusId_idx` (`campusId`),
  CONSTRAINT `FK_masterTimeTable_campusId` FOREIGN KEY (`campusId`) REFERENCES `campus` (`cmId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "mastertimetable"
#


#
# Structure for table "medical_details"
#

DROP TABLE IF EXISTS `medical_details`;
CREATE TABLE `medical_details` (
  `mid` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `Bloodgroup` varchar(45) DEFAULT NULL,
  `ailment` varchar(100) DEFAULT NULL,
  `Doctorname` varchar(200) DEFAULT NULL,
  `Doctor_address` varchar(200) DEFAULT NULL,
  `Mobile` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`mid`),
  KEY `FK_students_idx` (`user_id`),
  CONSTRAINT `FK_UserId` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

#
# Data for table "medical_details"
#

INSERT INTO `medical_details` VALUES (1,3,'A+','no','Dr Nagraj B Kotli','Revansiddeshwar Colony, Gulbarga Fort, Khuba Plot, Brhampur, Kalaburagi, Karnataka 585102','9012345678'),(2,4,'B+','no','Dr Nagraj B Kotli','Revansiddeshwar Colony, Gulbarga Fort, Khuba Plot, Brhampur, Kalaburagi, Karnataka 585102','9012345678'),(3,5,'A+','no','Dr Nagraj B Kotli','Revansiddeshwar Colony, Gulbarga Fort, Khuba Plot, Brhampur, Kalaburagi, Karnataka 585102','9012345678'),(4,21,'A+','fever','ak DR','Ring Road','9945711550');

#
# Structure for table "medicaldetails"
#

DROP TABLE IF EXISTS `medicaldetails`;
CREATE TABLE `medicaldetails` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Bloodgroup` int(11) DEFAULT NULL,
  `DoctorName` varchar(255) DEFAULT NULL,
  `Doctor_address` varchar(255) DEFAULT NULL,
  `Mobile` varchar(255) DEFAULT NULL,
  `ailment` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `mid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "medicaldetails"
#


#
# Structure for table "mothertongue"
#

DROP TABLE IF EXISTS `mothertongue`;
CREATE TABLE `mothertongue` (
  `motherTongueId` int(11) NOT NULL AUTO_INCREMENT,
  `motherTongueName` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`motherTongueId`),
  UNIQUE KEY `motherTongueName_UNIQUE` (`motherTongueName`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

#
# Data for table "mothertongue"
#

INSERT INTO `mothertongue` VALUES (1,'URDU'),(2,'KANNADA'),(3,'ENGLISH'),(4,'HINDI'),(5,'MARATHI'),(6,'TEMIL'),(7,'TELUGU');

#
# Structure for table "nationality"
#

DROP TABLE IF EXISTS `nationality`;
CREATE TABLE `nationality` (
  `nationalityId` int(11) NOT NULL AUTO_INCREMENT,
  `nationalityName` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`nationalityId`),
  UNIQUE KEY `nationalityName_UNIQUE` (`nationalityName`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

#
# Data for table "nationality"
#

INSERT INTO `nationality` VALUES (1,'INDIAN'),(2,'SRI LANKAN'),(3,'BANGLADESHI'),(4,'NEPALI'),(5,'AMERICAN'),(6,'EURROPEAN');

#
# Structure for table "notification"
#

DROP TABLE IF EXISTS `notification`;
CREATE TABLE `notification` (
  `notificationId` bigint(20) NOT NULL AUTO_INCREMENT,
  `notificationRaisedFrom` bigint(20) DEFAULT NULL,
  `notificationToPrimaryId` bigint(20) DEFAULT NULL,
  `notificationToSecondaryId` bigint(20) DEFAULT NULL,
  `notificationDescription` varchar(500) DEFAULT NULL,
  `campusId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`notificationId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

#
# Data for table "notification"
#

INSERT INTO `notification` VALUES (2,2,9,2,'message test',4);

#
# Structure for table "organization"
#

DROP TABLE IF EXISTS `organization`;
CREATE TABLE `organization` (
  `oId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `Type` varchar(45) DEFAULT NULL,
  `activated` tinyint(1) DEFAULT '0',
  `paid` tinyint(1) DEFAULT '0',
  `deleted` tinyint(1) DEFAULT '0',
  `id` int(11) NOT NULL,
  PRIMARY KEY (`oId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

#
# Data for table "organization"
#

INSERT INTO `organization` VALUES (3,'SBR','Education',1,1,0,0),(4,'Minds Solvit','IT',1,1,0,0);

#
# Structure for table "campus"
#

DROP TABLE IF EXISTS `campus`;
CREATE TABLE `campus` (
  `cmId` int(11) NOT NULL AUTO_INCREMENT,
  `campus_name` varchar(45) DEFAULT NULL,
  `organization_id` int(11) DEFAULT NULL,
  `campusAddress` varchar(100) DEFAULT NULL,
  `campusLocation` varchar(100) DEFAULT NULL,
  `cmorgflag` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL,
  `organizationName` int(11) DEFAULT NULL,
  PRIMARY KEY (`cmId`),
  KEY `Fk_Organization_ID_idx` (`organization_id`),
  CONSTRAINT `Fk_Organization_ID` FOREIGN KEY (`organization_id`) REFERENCES `organization` (`oId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

#
# Data for table "campus"
#

INSERT INTO `campus` VALUES (3,'SBR',3,'','',1,0,3),(4,'SBR School',3,'SB Temple Road Gulbarga','Gulbarga',0,0,3),(5,'Minds Solvit',4,'','',1,0,4),(6,'Minds Engineering College',4,'High Court','Gulbarga',0,0,4),(7,'Minds Medical College',4,'Ring Road','Gulbarga',0,0,4);

#
# Structure for table "class"
#

DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `campus_id` int(11) NOT NULL,
  `term_id` int(11) NOT NULL,
  `class_name` varchar(45) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_class_term1_idx` (`term_id`),
  KEY `Fk_campus_Id_idx` (`campus_id`),
  CONSTRAINT `Fk_campus_Id` FOREIGN KEY (`campus_id`) REFERENCES `campus` (`cmId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_class_term1` FOREIGN KEY (`term_id`) REFERENCES `term` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

#
# Data for table "class"
#

INSERT INTO `class` VALUES (4,4,3,'Class 1',0),(5,4,3,'Class 2',0),(6,4,3,'5th',0),(7,7,4,'7th Std',0);

#
# Structure for table "course"
#

DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(45) DEFAULT NULL,
  `deleted` tinyint(4) DEFAULT NULL,
  `class_id` bigint(20) NOT NULL,
  `course_id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_course_class1_idx` (`class_id`),
  KEY `fk_course_course1_idx` (`course_id`),
  CONSTRAINT `fk_course_class1` FOREIGN KEY (`class_id`) REFERENCES `class` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "course"
#

INSERT INTO `course` VALUES (1,'JAVA',1,4,1,'JAVA');

#
# Structure for table "course_staff"
#

DROP TABLE IF EXISTS `course_staff`;
CREATE TABLE `course_staff` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(45) NOT NULL,
  `course_id` int(11) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_course_instructor_course1_idx` (`course_id`),
  KEY `fk_course_staff_Staff_details1_idx` (`user_id`),
  CONSTRAINT `fk_course_instructor_course1` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "course_staff"
#


#
# Structure for table "assignment"
#

DROP TABLE IF EXISTS `assignment`;
CREATE TABLE `assignment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `assignment_name` varchar(45) DEFAULT NULL,
  `maxMarks` bigint(20) DEFAULT NULL,
  `minMarks` bigint(20) DEFAULT NULL,
  `max_score` decimal(10,0) DEFAULT NULL,
  `sequence` int(11) DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `due_date` datetime DEFAULT NULL,
  `subjectId` bigint(12) DEFAULT NULL,
  `classId` bigint(12) DEFAULT NULL,
  `sectionId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_assignment_subjectId_idx` (`subjectId`),
  KEY `FK_assignment_classId_idx` (`classId`),
  KEY `FK_assignment_sectionId_idx` (`sectionId`),
  CONSTRAINT `FK_assignment_classId` FOREIGN KEY (`classId`) REFERENCES `class` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_assignment_sectionId` FOREIGN KEY (`sectionId`) REFERENCES `section` (`sectionId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_assignment_subjectId` FOREIGN KEY (`subjectId`) REFERENCES `subject_master` (`subId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "assignment"
#


#
# Structure for table "assignment_grade"
#

DROP TABLE IF EXISTS `assignment_grade`;
CREATE TABLE `assignment_grade` (
  `id` int(11) NOT NULL,
  `score` decimal(10,0) DEFAULT NULL,
  `grade` decimal(10,0) DEFAULT NULL,
  `assignment_id` int(11) NOT NULL,
  `user_context_role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_assignment_grade_assignment1_idx` (`assignment_id`),
  KEY `fk_assignment_grade_user_context_role1_idx` (`user_context_role_id`),
  CONSTRAINT `fk_assignment_grade_assignment1` FOREIGN KEY (`assignment_id`) REFERENCES `assignment` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_assignment_grade_user_context_role1` FOREIGN KEY (`user_context_role_id`) REFERENCES `user_context_role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "assignment_grade"
#


#
# Structure for table "orgtokens"
#

DROP TABLE IF EXISTS `orgtokens`;
CREATE TABLE `orgtokens` (
  `otid` int(11) NOT NULL AUTO_INCREMENT,
  `token` varchar(200) DEFAULT NULL,
  `orgid` int(11) DEFAULT NULL,
  `createdat` date DEFAULT NULL,
  `lastupdated` date DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`otid`),
  KEY `Token_organization_Fk_idx` (`orgid`),
  CONSTRAINT `Token_organization_Fk` FOREIGN KEY (`orgid`) REFERENCES `organization` (`oId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Data for table "orgtokens"
#

INSERT INTO `orgtokens` VALUES (1,'Minds',4,'2017-09-04','2017-09-04',0),(2,'abcd',3,'2017-08-23','2017-08-23',0);

#
# Structure for table "previousterm"
#

DROP TABLE IF EXISTS `previousterm`;
CREATE TABLE `previousterm` (
  `preTrmId` int(11) NOT NULL AUTO_INCREMENT,
  `previousTermId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`preTrmId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "previousterm"
#


#
# Structure for table "religion"
#

DROP TABLE IF EXISTS `religion`;
CREATE TABLE `religion` (
  `religionId` int(11) NOT NULL AUTO_INCREMENT,
  `religionName` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`religionId`),
  UNIQUE KEY `religionName_UNIQUE` (`religionName`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

#
# Data for table "religion"
#

INSERT INTO `religion` VALUES (1,'ISLAM'),(2,'HINDUISM'),(3,'CHRISTIANITY'),(4,'SIKHISM '),(5,'BUDDHISM'),(6,'JAINISM'),(7,'ZOROASTRIANISM'),(8,'JUDAISM ');

#
# Structure for table "resetkeys"
#

DROP TABLE IF EXISTS `resetkeys`;
CREATE TABLE `resetkeys` (
  `userId` int(10) unsigned NOT NULL,
  `key` char(32) NOT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  UNIQUE KEY `userId` (`userId`,`key`),
  KEY `created` (`created`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "resetkeys"
#


#
# Structure for table "result"
#

DROP TABLE IF EXISTS `result`;
CREATE TABLE `result` (
  `resId` bigint(11) NOT NULL AUTO_INCREMENT,
  `dateOfResult` date DEFAULT NULL,
  `userId` bigint(11) DEFAULT NULL,
  `totalMaxMarks` bigint(11) DEFAULT NULL,
  `totalMinMarks` bigint(11) DEFAULT NULL,
  `totalMarksObtained` bigint(11) DEFAULT NULL,
  `marksInWords` varchar(100) DEFAULT NULL,
  `resultClass` varchar(100) DEFAULT NULL,
  `average` double(7,4) DEFAULT NULL,
  `stdClsMapId` bigint(12) DEFAULT '0',
  `examId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`resId`),
  KEY `FK_result_userId_idx` (`userId`),
  KEY `result_exam_idx` (`examId`),
  CONSTRAINT `FK_result_userId` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `result_exam` FOREIGN KEY (`examId`) REFERENCES `exam_master` (`examId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Data for table "result"
#

INSERT INTO `result` VALUES (1,'2017-08-23',5,400,180,305,'Three Zero Five ','pass',76.0000,4,2),(2,'2017-08-23',6,400,180,313,'Three One Three ','pass',78.0000,5,2);

#
# Structure for table "role"
#

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "role"
#


#
# Structure for table "route"
#

DROP TABLE IF EXISTS `route`;
CREATE TABLE `route` (
  `ROUTE_ID` int(11) NOT NULL,
  `DESTINATION` varchar(255) DEFAULT NULL,
  `SOURCE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ROUTE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "route"
#

INSERT INTO `route` VALUES (1,NULL,NULL),(2,NULL,NULL),(3,NULL,NULL),(4,NULL,NULL),(5,NULL,NULL),(6,NULL,NULL),(7,'gulbarga','Bidar'),(8,NULL,NULL),(9,NULL,NULL),(10,NULL,NULL),(11,NULL,NULL),(12,NULL,NULL),(13,NULL,NULL),(14,NULL,NULL),(15,NULL,NULL),(16,NULL,NULL);

#
# Structure for table "busroute_details"
#

DROP TABLE IF EXISTS `busroute_details`;
CREATE TABLE `busroute_details` (
  `busDetails_id` int(11) NOT NULL,
  `route_id` int(11) NOT NULL,
  PRIMARY KEY (`busDetails_id`,`route_id`),
  KEY `FKmpqn7i746rxnke7jl2xsd1ag1` (`route_id`),
  CONSTRAINT `FKhhriclk3octu0h1o8em0k6y2q` FOREIGN KEY (`busDetails_id`) REFERENCES `busdetails` (`busDetails_id`),
  CONSTRAINT `FKmpqn7i746rxnke7jl2xsd1ag1` FOREIGN KEY (`route_id`) REFERENCES `route` (`ROUTE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "busroute_details"
#

INSERT INTO `busroute_details` VALUES (12,12);

#
# Structure for table "route_details"
#

DROP TABLE IF EXISTS `route_details`;
CREATE TABLE `route_details` (
  `rdId` int(11) NOT NULL AUTO_INCREMENT,
  `Route_Name` varchar(120) DEFAULT NULL,
  `No_of_Stops` int(11) DEFAULT NULL,
  `Vehicle_id` int(11) NOT NULL,
  PRIMARY KEY (`rdId`),
  KEY `fk_Route_details_Vehicle_details1_idx` (`Vehicle_id`),
  CONSTRAINT `fk_Route_details_Vehicle_details1` FOREIGN KEY (`Vehicle_id`) REFERENCES `vehicle_details` (`vdId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

#
# Data for table "route_details"
#

INSERT INTO `route_details` VALUES (2,'SBR School',1,2),(3,'market',2,3),(4,'Station to Bus Stand',1,4);

#
# Structure for table "school_logo"
#

DROP TABLE IF EXISTS `school_logo`;
CREATE TABLE `school_logo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Photo_file_name` varchar(120) DEFAULT NULL,
  `Photo_Content_Type` varchar(120) DEFAULT NULL,
  `Photo_file_Size` varchar(120) DEFAULT NULL,
  `Photo_data_blob` blob,
  `Campus_ID` int(11) DEFAULT NULL,
  `holidayId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Fk_CampusId_idx` (`Campus_ID`),
  KEY `Fk_HolidayId_idx` (`holidayId`),
  CONSTRAINT `Fk_CampusId` FOREIGN KEY (`Campus_ID`) REFERENCES `campus` (`cmId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Fk_Holiday_Id_School_logo` FOREIGN KEY (`holidayId`) REFERENCES `holidays` (`hId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Data for table "school_logo"
#

INSERT INTO `school_logo` VALUES (1,'school-Logo','BLOB','150',NULL,4,3),(2,'school-images','BLOB','200',NULL,4,3);

#
# Structure for table "school_news"
#

DROP TABLE IF EXISTS `school_news`;
CREATE TABLE `school_news` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `schoolId` int(11) DEFAULT NULL,
  `headlines` varchar(200) DEFAULT NULL,
  `newsdesc` varchar(1000) DEFAULT NULL,
  `newsdate` date DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Fk_schoolNews_school_Id_idx` (`schoolId`),
  CONSTRAINT `Fk_schoolNews_school_Id` FOREIGN KEY (`schoolId`) REFERENCES `school_logo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "school_news"
#


#
# Structure for table "section"
#

DROP TABLE IF EXISTS `section`;
CREATE TABLE `section` (
  `sectionId` bigint(20) NOT NULL AUTO_INCREMENT,
  `sectionName` varchar(100) DEFAULT NULL,
  `classId` bigint(20) DEFAULT NULL,
  `sectionFlag` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`sectionId`),
  KEY `FK_class_section_idx` (`classId`),
  CONSTRAINT `FK_class_section` FOREIGN KEY (`classId`) REFERENCES `class` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

#
# Data for table "section"
#

INSERT INTO `section` VALUES (2,'Section 1',4,0),(3,'Section 2',4,0),(4,'Section 1',5,0),(5,'Section 2',5,0),(6,'A',6,0),(7,'A Section',7,0);

#
# Structure for table "class_timetable"
#

DROP TABLE IF EXISTS `class_timetable`;
CREATE TABLE `class_timetable` (
  `TtId` bigint(11) NOT NULL AUTO_INCREMENT,
  `classId` bigint(20) DEFAULT NULL,
  `weekDayId` bigint(20) DEFAULT NULL,
  `sectionId` bigint(20) DEFAULT NULL,
  `subjectName` varchar(100) DEFAULT NULL,
  `startTime` varchar(25) DEFAULT NULL,
  `endTime` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`TtId`),
  KEY `Fk_Section_ClsTmTable_idx` (`sectionId`),
  KEY `Fk_ClassId_CLSTMTBLE_idx` (`classId`),
  CONSTRAINT `Fk_Section_ClsTmTable` FOREIGN KEY (`sectionId`) REFERENCES `section` (`sectionId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

#
# Data for table "class_timetable"
#

INSERT INTO `class_timetable` VALUES (2,4,1,2,'English','09:10AM','10:00AM'),(3,4,1,2,'Hindi','10:00AM','11:15AM'),(4,4,1,2,'Maths','11:15AM','12:15PM'),(5,4,2,2,'Hindi','09:10AM','10:00AM'),(6,4,3,2,'Maths','09:10AM','10:00AM'),(7,4,4,2,'English','09:10AM','10:00AM'),(8,4,5,2,'Science','09:10AM','10:00AM'),(9,4,6,2,'Science','09:10AM','10:00AM'),(10,4,4,2,'Maths','01:15PM','02:00PM');

#
# Structure for table "sectionchange"
#

DROP TABLE IF EXISTS `sectionchange`;
CREATE TABLE `sectionchange` (
  `sectionChangeId` bigint(20) NOT NULL AUTO_INCREMENT,
  `studentAdmNum` varchar(60) DEFAULT NULL,
  `studentUserId` bigint(20) DEFAULT NULL,
  `classId` bigint(20) DEFAULT NULL COMMENT 'Student Current Class Id',
  `sectionId` bigint(20) DEFAULT NULL COMMENT 'Before Section Change Id ',
  `changedSectionId` bigint(20) DEFAULT NULL COMMENT 'After Section Change Id ',
  `campusId` int(11) DEFAULT NULL,
  `campusAdminUserId` bigint(20) DEFAULT NULL COMMENT 'The Person Who has moved Student from one section to another',
  `dateOfChange` datetime DEFAULT NULL COMMENT 'Date of changed student section',
  PRIMARY KEY (`sectionChangeId`),
  KEY `fk_student_secChng_idx` (`studentUserId`),
  KEY `fk_class_secChng_idx` (`classId`),
  KEY `fk_section_secChng_idx` (`sectionId`),
  KEY `fk_campus_secChng_idx` (`campusId`),
  CONSTRAINT `fk_campus_secChng` FOREIGN KEY (`campusId`) REFERENCES `campus` (`cmId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_class_secChng` FOREIGN KEY (`classId`) REFERENCES `class` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_section_secChng` FOREIGN KEY (`sectionId`) REFERENCES `section` (`sectionId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_student_secChng` FOREIGN KEY (`studentUserId`) REFERENCES `student_details` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "sectionchange"
#


#
# Structure for table "staff_class_map"
#

DROP TABLE IF EXISTS `staff_class_map`;
CREATE TABLE `staff_class_map` (
  `stfClsMapId` bigint(12) NOT NULL AUTO_INCREMENT,
  `classId` bigint(12) DEFAULT NULL,
  `userId` bigint(12) DEFAULT NULL,
  `subjectId` bigint(12) DEFAULT NULL,
  `sectionId` bigint(12) DEFAULT NULL,
  PRIMARY KEY (`stfClsMapId`),
  KEY `FK_stfClsMap_ClassId_idx` (`classId`),
  KEY `FK_stfClsMap_userId_idx` (`userId`),
  KEY `FK_stfClsMap_sectionId_idx` (`sectionId`),
  CONSTRAINT `FK_stfClsMap_classId` FOREIGN KEY (`classId`) REFERENCES `class` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_stfClsMap_sectionId` FOREIGN KEY (`sectionId`) REFERENCES `section` (`sectionId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_stfClsMap_userId` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

#
# Data for table "staff_class_map"
#

INSERT INTO `staff_class_map` VALUES (4,4,3,6,2),(5,4,3,6,3),(6,4,3,7,2),(7,4,4,8,2),(8,4,4,9,2),(9,7,17,11,7);

#
# Structure for table "staff_details"
#

DROP TABLE IF EXISTS `staff_details`;
CREATE TABLE `staff_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `vehicleId` int(11) DEFAULT NULL,
  `staffUniqueId` bigint(20) DEFAULT NULL,
  `staffTeacherClassId` bigint(20) DEFAULT NULL,
  `documentsSubmitted` varchar(200) DEFAULT NULL,
  `religionId` int(11) DEFAULT NULL,
  `motherTongueId` int(11) DEFAULT NULL,
  `categoryId` int(11) DEFAULT NULL,
  `nationalityId` int(11) DEFAULT NULL,
  `staff_detailscol` varchar(45) DEFAULT NULL,
  `staff_detailscol1` varchar(45) DEFAULT NULL,
  `campusId` int(11) DEFAULT NULL,
  `classId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Staffdetails_Context_idx` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

#
# Data for table "staff_details"
#

INSERT INTO `staff_details` VALUES (4,3,2,NULL,4,'no',2,2,8,1,NULL,NULL,4,4),(5,4,2,NULL,0,'no',2,2,8,1,NULL,NULL,5,5),(6,17,0,NULL,0,'Exp Certificate',1,1,1,1,NULL,NULL,4,6),(7,18,0,NULL,0,'Exp',1,1,1,1,NULL,NULL,5,4),(8,21,4,NULL,7,'tc',1,2,3,3,NULL,NULL,4,5),(9,24,4,NULL,7,'afsgf',1,1,1,1,NULL,NULL,5,6),(10,26,0,NULL,0,'h',1,2,2,3,NULL,NULL,4,4);

#
# Structure for table "attendance"
#

DROP TABLE IF EXISTS `attendance`;
CREATE TABLE `attendance` (
  `atdId` bigint(20) NOT NULL AUTO_INCREMENT,
  `studentUserId` bigint(20) DEFAULT NULL,
  `Studentadminno` varchar(50) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `DOI` date DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `staffUserId` bigint(20) DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  `Firstname` varchar(255) DEFAULT NULL,
  `campusName` varchar(255) DEFAULT NULL,
  `className` varchar(255) DEFAULT NULL,
  `orgName` varchar(255) DEFAULT NULL,
  `stud_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`atdId`),
  KEY `FK_staffUserId_idx` (`staffUserId`),
  KEY `FK_studentUserId_idx` (`studentUserId`),
  CONSTRAINT `FK_staffUserId` FOREIGN KEY (`staffUserId`) REFERENCES `staff_details` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

#
# Data for table "attendance"
#

INSERT INTO `attendance` VALUES (5,5,'adm01','Absent',0,'2017-08-23','2017-08-23 09:17:39',3,0,NULL,NULL,NULL,NULL,'4'),(6,6,'adm02','Present',1,'2017-08-23','2017-08-23 09:17:39',3,0,NULL,NULL,NULL,NULL,'5');

#
# Structure for table "staff_subject_map"
#

DROP TABLE IF EXISTS `staff_subject_map`;
CREATE TABLE `staff_subject_map` (
  `stfSubMapId` bigint(12) NOT NULL AUTO_INCREMENT,
  `subId` bigint(12) DEFAULT NULL,
  `userId` bigint(12) DEFAULT NULL,
  PRIMARY KEY (`stfSubMapId`),
  KEY `FK_staffSubMap_SubjectMasterID_idx` (`subId`),
  KEY `FK_staffSubMap_StaffDetails_idx` (`userId`),
  CONSTRAINT `FK_staffSubMap_StaffDetails` FOREIGN KEY (`userId`) REFERENCES `staff_details` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_staffSubMap_SubjectMasterID` FOREIGN KEY (`subId`) REFERENCES `subject_master` (`subId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "staff_subject_map"
#


#
# Structure for table "staffattendance"
#

DROP TABLE IF EXISTS `staffattendance`;
CREATE TABLE `staffattendance` (
  `stfAtndId` bigint(20) NOT NULL AUTO_INCREMENT,
  `staffUserId` bigint(20) DEFAULT NULL,
  `staffFirstName` varchar(100) DEFAULT NULL,
  `campusId` bigint(20) DEFAULT NULL,
  `remarks` varchar(500) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `dateOfAttendance` date DEFAULT NULL,
  `updatedOn` datetime DEFAULT NULL,
  `campusAdminUserId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`stfAtndId`),
  KEY `FK_staffUserId_staffAttendance_idx` (`staffUserId`),
  KEY `FK_campusAdminUserId_userId_idx` (`campusAdminUserId`),
  CONSTRAINT `FK_campusAdminUserId_userId` FOREIGN KEY (`campusAdminUserId`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_staffUserId_staffAttendance` FOREIGN KEY (`staffUserId`) REFERENCES `staff_details` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

#
# Data for table "staffattendance"
#

INSERT INTO `staffattendance` VALUES (1,3,'Anu',4,'Absent',0,'2017-08-23','2017-08-23 00:00:00',2),(2,4,'Preeti',4,'Present',1,'2017-08-23','2017-08-23 00:00:00',2),(3,3,'Anu',4,'Present',1,'2017-08-24','2017-08-24 00:00:00',2),(4,4,'Preeti',4,'Present',1,'2017-08-24','2017-08-24 00:00:00',2);

#
# Structure for table "state"
#

DROP TABLE IF EXISTS `state`;
CREATE TABLE `state` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `statename` varchar(200) DEFAULT NULL,
  `countryid` int(11) DEFAULT NULL,
  `createat` date DEFAULT NULL,
  `updatedat` date DEFAULT NULL,
  PRIMARY KEY (`sid`),
  KEY `state_country_fk_idx` (`countryid`),
  CONSTRAINT `state_country_fk` FOREIGN KEY (`countryid`) REFERENCES `country` (`cid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "state"
#


#
# Structure for table "city"
#

DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `ctid` int(11) NOT NULL AUTO_INCREMENT,
  `cityname` varchar(200) DEFAULT NULL,
  `stateid` int(11) DEFAULT NULL,
  `createat` date DEFAULT NULL,
  `updatedat` date DEFAULT NULL,
  PRIMARY KEY (`ctid`),
  KEY `city_state_fk_idx` (`stateid`),
  CONSTRAINT `city_state_fk` FOREIGN KEY (`stateid`) REFERENCES `state` (`sid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "city"
#


#
# Structure for table "stop_details"
#

DROP TABLE IF EXISTS `stop_details`;
CREATE TABLE `stop_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Stop_Name` varchar(120) DEFAULT NULL,
  `fare` varchar(120) DEFAULT NULL,
  `Arival_Mrng` varchar(120) DEFAULT NULL,
  `Departure_Mrng` varchar(120) DEFAULT NULL,
  `Arival_Evng` varchar(120) DEFAULT NULL,
  `Departure_Evng` varchar(120) DEFAULT NULL,
  `Route_details_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Stop_Details_Route_details1_idx` (`Route_details_id`),
  CONSTRAINT `fk_Stop_Details_Route_details1` FOREIGN KEY (`Route_details_id`) REFERENCES `route_details` (`rdId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

#
# Data for table "stop_details"
#

INSERT INTO `stop_details` VALUES (3,'SBR','123','09:00 AM','09:10 AM','05:00 PM','05:10 PM',2),(4,'shantrashwadi','30','09:00 AM','09:10 AM','04:00 PM','04:15 PM',3),(5,'MB Nagar','4','09:20 AM','09:25 AM','04:10 PM','04:20 PM',3),(6,'mystop','55','10:00 am','10:05 AM','06:00 pm','06:05 pm',4);

#
# Structure for table "student_class"
#

DROP TABLE IF EXISTS `student_class`;
CREATE TABLE `student_class` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `class_id` bigint(20) NOT NULL,
  `sectionId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_context_has_class_class1_idx` (`class_id`),
  KEY `fk_user_context_has_class_user_context1_idx` (`user_id`),
  KEY `fk_section_student_class_idx` (`sectionId`),
  CONSTRAINT `fk_section_student_class` FOREIGN KEY (`sectionId`) REFERENCES `section` (`sectionId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_context_has_class_class1` FOREIGN KEY (`class_id`) REFERENCES `class` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_context_has_class_user_context1` FOREIGN KEY (`user_id`) REFERENCES `student_details` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

#
# Data for table "student_class"
#

INSERT INTO `student_class` VALUES (4,5,4,2),(5,6,4,2),(6,7,4,3),(7,8,4,3),(8,20,7,7);

#
# Structure for table "student_details"
#

DROP TABLE IF EXISTS `student_details`;
CREATE TABLE `student_details` (
  `sdId` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `Studentadminno` bigint(20) DEFAULT NULL,
  `vehicleId` int(11) DEFAULT NULL,
  `eventId` bigint(15) DEFAULT NULL,
  `documentsSubmitted` varchar(200) DEFAULT NULL,
  `religionId` int(11) DEFAULT NULL,
  `motherTongueId` int(11) DEFAULT NULL,
  `categoryId` int(11) DEFAULT NULL,
  `nationalityId` int(11) DEFAULT NULL,
  `cmId` int(11) DEFAULT NULL,
  `classId` int(11) DEFAULT NULL,
  `bookId` int(11) DEFAULT NULL,
  PRIMARY KEY (`sdId`),
  KEY `fk_student_user_context1_idx` (`user_id`),
  KEY `Students_Books_idx` (`bookId`),
  CONSTRAINT `Students_Books` FOREIGN KEY (`bookId`) REFERENCES `books` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

#
# Data for table "student_details"
#

INSERT INTO `student_details` VALUES (4,5,1,2,0,'no',3,2,8,1,3,4,4),(5,6,2,2,0,'no',2,2,5,1,4,5,5),(6,7,3,2,0,'no',2,2,8,1,3,6,4),(7,8,4,2,0,'no',2,2,8,1,4,4,5),(8,20,89,4,0,'TC',1,1,1,1,5,5,4),(12,5,1,2,0,'no',2,2,8,1,3,4,4),(13,5,1,2,0,'no',2,2,8,1,3,4,4),(14,5,1,2,0,'no',2,2,8,1,3,4,4),(15,5,1,2,0,'no',2,2,8,1,3,4,4),(16,5,1,2,0,'no',2,2,8,1,3,4,4),(19,5,1,2,0,'no',2,2,8,1,3,4,4);

#
# Structure for table "coursemembership"
#

DROP TABLE IF EXISTS `coursemembership`;
CREATE TABLE `coursemembership` (
  `sdId` bigint(20) NOT NULL,
  `courseId` varchar(45) DEFAULT NULL,
  `datasourceId` varchar(45) DEFAULT NULL,
  `created` date DEFAULT NULL,
  `availability` varchar(45) DEFAULT NULL,
  `lastAccessed` date DEFAULT NULL,
  `avaliability` datetime DEFAULT NULL,
  PRIMARY KEY (`sdId`),
  KEY `foreignkey_sdId_idx` (`sdId`),
  CONSTRAINT `foreignkey_sdId` FOREIGN KEY (`sdId`) REFERENCES `student_details` (`sdId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "coursemembership"
#

INSERT INTO `coursemembership` VALUES (4,'1','1','2018-08-02','yes','2018-02-07',NULL);

#
# Structure for table "student_guardian_mapping"
#

DROP TABLE IF EXISTS `student_guardian_mapping`;
CREATE TABLE `student_guardian_mapping` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gid` bigint(20) DEFAULT NULL,
  `stdadmissionno` varchar(200) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

#
# Data for table "student_guardian_mapping"
#

INSERT INTO `student_guardian_mapping` VALUES (3,2,'adm01',9),(4,2,'adm04',9),(5,3,'A0889',22);

#
# Structure for table "subject_class_mapping"
#

DROP TABLE IF EXISTS `subject_class_mapping`;
CREATE TABLE `subject_class_mapping` (
  `SubClassId` bigint(11) NOT NULL AUTO_INCREMENT,
  `subjectId` bigint(20) DEFAULT NULL,
  `classId` bigint(20) DEFAULT NULL,
  `sectionId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`SubClassId`),
  KEY `FK_subCLsMap_section_idx` (`sectionId`),
  CONSTRAINT `FK_subCLsMap_section` FOREIGN KEY (`sectionId`) REFERENCES `section` (`sectionId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

#
# Data for table "subject_class_mapping"
#

INSERT INTO `subject_class_mapping` VALUES (6,6,4,2),(7,7,4,2),(8,8,4,2),(9,9,4,2),(10,6,4,3),(11,7,4,3),(12,8,4,3),(13,9,4,3),(14,8,6,6),(15,11,7,7);

#
# Structure for table "subject_master"
#

DROP TABLE IF EXISTS `subject_master`;
CREATE TABLE `subject_master` (
  `subId` bigint(11) NOT NULL AUTO_INCREMENT,
  `subjectName` varchar(60) DEFAULT NULL,
  `createdOn` date DEFAULT NULL,
  `updatedOn` date DEFAULT NULL,
  `campusId` int(12) DEFAULT NULL,
  PRIMARY KEY (`subId`),
  KEY `FK_subject_master_campus_idx` (`campusId`),
  CONSTRAINT `FK_subject_master_campus` FOREIGN KEY (`campusId`) REFERENCES `campus` (`cmId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

#
# Data for table "subject_master"
#

INSERT INTO `subject_master` VALUES (6,'English','2017-08-23','2017-08-23',4),(7,'Hindi','2017-08-23','2017-08-23',4),(8,'Maths','2017-08-23','2017-08-23',4),(9,'Science','2017-08-23','2017-08-23',4),(10,'Computer Science','2017-08-24','2017-08-24',4),(11,'English','2017-09-04','2017-09-04',7);

#
# Structure for table "term"
#

DROP TABLE IF EXISTS `term`;
CREATE TABLE `term` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `termName` varchar(100) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT NULL,
  `term_type_id` int(11) NOT NULL,
  `campus_id` int(11) NOT NULL,
  `active` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_term_term_type1_idx` (`term_type_id`),
  KEY `Fk_campusId_id_idx` (`campus_id`),
  CONSTRAINT `Fk_campusId_id` FOREIGN KEY (`campus_id`) REFERENCES `campus` (`cmId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_term_term_type1` FOREIGN KEY (`term_type_id`) REFERENCES `term_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

#
# Data for table "term"
#

INSERT INTO `term` VALUES (3,'Year2017','2017-01-01','2017-12-01',0,1,4,1),(4,'First Term','2017-09-01','2017-11-30',0,2,7,1);

#
# Structure for table "term_type"
#

DROP TABLE IF EXISTS `term_type`;
CREATE TABLE `term_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `term_type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Data for table "term_type"
#

INSERT INTO `term_type` VALUES (1,'Year'),(2,'Semester');

#
# Structure for table "timetable"
#

DROP TABLE IF EXISTS `timetable`;
CREATE TABLE `timetable` (
  `ttId` int(11) NOT NULL AUTO_INCREMENT,
  `masterTimeTableId` int(11) DEFAULT NULL,
  `campusId` int(11) DEFAULT NULL,
  `classId` bigint(20) DEFAULT NULL,
  `periodNumber` int(11) DEFAULT NULL,
  `subjectId` bigint(11) DEFAULT NULL,
  `day` varchar(45) DEFAULT NULL,
  `periodStartTime` varchar(45) DEFAULT NULL,
  `periodEndTime` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ttId`),
  KEY `FK_masterTimeTable_idx` (`masterTimeTableId`),
  KEY `FK_campusId_campus_idx` (`campusId`),
  KEY `FK_classId_class_idx` (`classId`),
  KEY `FK_subjectId_subject_idx` (`subjectId`),
  CONSTRAINT `FK_campusId_campus` FOREIGN KEY (`campusId`) REFERENCES `campus` (`cmId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_classId_class` FOREIGN KEY (`classId`) REFERENCES `class` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_masterTimeTable_timeTable` FOREIGN KEY (`masterTimeTableId`) REFERENCES `mastertimetable` (`mttId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_subjectId_subject` FOREIGN KEY (`subjectId`) REFERENCES `subject_master` (`subId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "timetable"
#


#
# Structure for table "traindetails"
#

DROP TABLE IF EXISTS `traindetails`;
CREATE TABLE `traindetails` (
  `trainId` int(11) NOT NULL,
  `destination` varchar(255) DEFAULT NULL,
  `route` varchar(255) DEFAULT NULL,
  `source` varchar(255) DEFAULT NULL,
  `time` bigint(20) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`trainId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "traindetails"
#


#
# Structure for table "user"
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `Firstname` varchar(200) DEFAULT NULL,
  `MiddleName` varchar(200) DEFAULT NULL,
  `Lastname` varchar(200) DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `Address1` varchar(200) DEFAULT NULL,
  `Address2` varchar(200) DEFAULT NULL,
  `City` varchar(200) DEFAULT NULL,
  `State` varchar(200) DEFAULT NULL,
  `Createat` datetime DEFAULT NULL,
  `Updatedat` datetime DEFAULT NULL,
  `Deleted` bigint(20) DEFAULT NULL,
  `hasher` varchar(255) DEFAULT NULL,
  `salt` varchar(225) DEFAULT NULL,
  `Gender` varchar(45) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `salary` bigint(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

#
# Data for table "user"
#

INSERT INTO `user` VALUES (1,'Aadarsh','Aadi','Patil','1990-02-01','$2a$10$C2yeWoByyndzPob8iuFYL.Jhy94QcVKj6AjyyCmWM9MyenTbSc/s2','Gulbarga','Gulbarga','Gulbarga','Karnataka','2017-08-23 07:04:40','2017-08-23 07:04:40',1,'bcrypt',NULL,'Male',NULL,NULL,NULL),(2,'Aaditya','Aalok','Deshmuk','1990-02-06','$2a$10$ycmh01GGc5EeJaA6BKQLcebtyggDQqDVvHBv8k.Ahtl7DkZieoj2a','Gulbarga','Gulbarga','Gulbarga','Karnataka','2017-08-23 07:20:49','2017-08-23 07:20:49',1,'bcrypt',NULL,'Male',NULL,NULL,NULL),(3,'Anu','Aamir','Patil','1990-07-18','$2a$10$IWppVa8F2EGApOt1LCi.5.IkOPsMpYFtF/OVs2.1KyBW20KGnt3n6','Gulbarga','Gulbarga','Gulbarga','Karnataka','2017-08-23 07:31:52','2017-08-23 07:31:52',1,'bcrypt',NULL,'Male',NULL,NULL,NULL),(4,'Preeti','Aanand','Aarav','1999-02-11','$2a$10$V7Vw3lXEpM4MLmij08W2YOyB3Emm4aTrAcumtDJLsrXPfQGMyQGaK','Gulbarga','Gulbarga','Gulbarga','Karnataka','2017-08-23 07:41:01','2017-08-23 07:41:01',1,'bcrypt',NULL,'Female',NULL,NULL,NULL),(5,'Aarin','Aamir','Patil','2010-02-02','$2a$10$juYPO0XBps.yXThh6niMBOlZwIoTCom4/xIFL2EEIK4PxaxI18RVm','Gulbarga','Gulbarga','Gulbarga','Karnataka','2017-08-23 08:55:47','2017-08-23 08:55:47',1,'bcrypt',NULL,'Male',NULL,NULL,NULL),(6,'Aanav','Aamir','Kulkarni','2010-06-17','$2a$10$juYPO0XBps.yXThh6niMBOlZwIoTCom4/xIFL2EEIK4PxaxI18RVm','Gulbarga','Gulbarga','Gulbarga','Karnataka','2017-08-23 08:58:21','2017-08-23 08:58:21',1,'bcrypt',NULL,'Male',NULL,NULL,NULL),(7,'Aashman','Aalok','Deshmuk','2010-07-14','$2a$10$juYPO0XBps.yXThh6niMBOlZwIoTCom4/xIFL2EEIK4PxaxI18RVm','Gulbarga','Gulbarga','Gulbarga','Karnataka','2017-08-23 09:00:16','2017-08-23 09:00:16',1,'bcrypt',NULL,'Male',NULL,NULL,NULL),(8,'Aayan','G','Kulkarni','2010-06-16','$2a$10$juYPO0XBps.yXThh6niMBOlZwIoTCom4/xIFL2EEIK4PxaxI18RVm','Gulbarga','Gulbarga','Gulbarga','Karnataka','2017-08-23 09:02:10','2017-08-23 09:02:10',1,'bcrypt',NULL,'Male',NULL,NULL,NULL),(9,'Aarin','Aamir','Kulkarni','1999-02-10','$2a$10$eTJAivWMeKPKfbAxd5l8G.FE6JRMiNZ865IqMsXVMNkwzTTXnqHHm','Gulbarga','Gulbarga','Gulbarga','Karnataka','2017-08-23 09:04:43','2017-08-23 09:04:43',1,'bcrypt',NULL,'Male',NULL,NULL,NULL),(10,'librAdmin','B','vc','1999-02-13','$2a$10$tEWgAOuCkxkFySE.UV6W9eBdsDRi4NOpKd0k4ghbtJu1B39DM9oPi','Gulbarga','Gulbarga','Gulbarga','Karnataka','2017-08-23 09:07:33','2017-08-23 09:07:33',1,'bcrypt',NULL,'Male',NULL,NULL,NULL),(11,'Siddu','Hiremath','Hiremath','2017-08-08','$2a$10$U9gTWEGAbitgjXy.0So/SuiW3xxfMYsmFbigFRc7mgSFiaxT/FX4K','MB Nagar extension Area','Durga Gulbarga','kalaburgi','Karnataka','2017-08-24 11:46:43','2017-08-24 11:46:43',1,'bcrypt',NULL,'Male',NULL,NULL,NULL),(12,'Siddu','Hiremath','Hiremath','2017-08-08','$2a$10$U9gTWEGAbitgjXy.0So/SuiW3xxfMYsmFbigFRc7mgSFiaxT/FX4K','MB Nagar extension Area','Durga Gulbarga','kalaburgi','Karnataka','2017-08-24 11:47:00','2017-08-24 11:47:00',1,'bcrypt',NULL,'Male',NULL,NULL,NULL),(13,'Siddu','Hiremath','Hiremath','2017-08-08','$2a$10$U9gTWEGAbitgjXy.0So/SuiW3xxfMYsmFbigFRc7mgSFiaxT/FX4K','MB Nagar extension Area','Durga Gulbarga','kalaburgi','Karnataka','2017-08-24 11:47:28','2017-08-24 11:47:28',1,'bcrypt',NULL,'Male',NULL,NULL,NULL),(14,'Siddu','Hiremath','Hiremath','2017-08-08','$2a$10$U9gTWEGAbitgjXy.0So/SuiW3xxfMYsmFbigFRc7mgSFiaxT/FX4K','MB Nagar extension Area','Durga Gulbarga','kalaburgi','Karnataka','2017-08-24 11:47:53','2017-08-24 11:47:53',1,'bcrypt',NULL,'Male',NULL,NULL,NULL),(15,'Md','Abdul','Khader','1988-07-11','$2a$10$O3hvdR/Bm3dpXFikvQ4EW.78oICf.KWAHVipb5Ssgx2hMr4OyZEt.','High Court','Ring Road','Gulbarga','Karnataka','2017-09-04 08:46:02','2017-09-04 08:46:02',1,'bcrypt',NULL,'Male',NULL,NULL,NULL),(16,'Mohammed','Abdul','Khader','1980-02-06','$2a$10$uibNTMOjnbxkH.NTl6AWa.K4fCp3MPpZAxZoIyIOGdybFhNeXUJLe','High Courtt','Ring Roadd','Gulbargaaa','Karnataka','2017-09-04 09:01:52','2017-09-04 09:01:52',1,'bcrypt',NULL,'Male',NULL,NULL,NULL),(17,'Sandeep','Sandy','Sandip','1990-01-30','$2a$10$iZJB1e9H2wVQ.4mDV3XUWOBqA.ss.L6w9RpIQZN5YLB39tLwi.7aW','Ak Address','Ak Correspndance Address','Gulbarga','Karnataka','2017-09-04 09:13:23','2017-09-04 09:13:23',1,'bcrypt',NULL,'Male',NULL,NULL,NULL),(18,'Abdul','Khader','Khaderrr','2000-10-24','$2a$10$1wg.AJvtB6RbG9CxBVMFSueSwK3xBuOU/4u0e5ARs67xLE1Mc9UEi','Gulbarga','Kalburagi','Gulbarga','Karnataka','2017-09-04 09:16:48','2017-09-04 09:16:48',1,'bcrypt',NULL,'Male',NULL,NULL,NULL),(19,'M','A','K','2000-02-16','$2a$10$U9gTWEGAbitgjXy.0So/SuiW3xxfMYsmFbigFRc7mgSFiaxT/FX4K','High Court','Hig','Gulbarga','Karnataka','2017-09-04 09:29:12','2017-09-04 09:29:12',1,'bcrypt',NULL,'Male',NULL,NULL,NULL),(20,'Md','Abdu','Khad','2015-06-09','$2a$10$juYPO0XBps.yXThh6niMBOlZwIoTCom4/xIFL2EEIK4PxaxI18RVm','KC','KC1','Gulbarga','Karnataka','2017-09-04 09:36:38','2017-09-04 09:36:38',1,'bcrypt',NULL,'Male',NULL,NULL,NULL),(21,'Abdul','K','Khader','2010-02-02','$2a$10$uy4Bc5Ujqzoi6HCMpDAfb.8lk1uRcZ1ommbFcXAXQeFwtm2X.sgKu','my address','my address 2','Gulbargaaaaa','Karnataka','2017-09-05 06:55:52','2017-09-05 06:55:52',1,'bcrypt',NULL,'Male',NULL,NULL,NULL),(22,'parenttt','par','part','1999-06-02','$2a$10$G/JvgimOypK1tvMEVof7leEbkQi2SHcYKRwBBRROTnRC7leZX5MKG','ak add','ak addr','glb','Karnataka','2017-09-05 09:00:34','2017-09-05 09:00:34',1,'bcrypt',NULL,'Male',NULL,NULL,NULL),(23,'Abdul k','Khader','Mohd','2000-06-07','$2a$10$MWbdDjhOKjKwxet.cX/XGePMrLTFa/7WmOrgZqFezrJF8MVxLWuF.','ring road','ak address','glbbbb','Karnataka','2017-09-05 09:17:43','2017-09-05 09:17:43',1,'bcrypt',NULL,'Male',NULL,NULL,NULL),(24,'ak','akk','akkkk','2017-09-19','$2a$10$5L1P1ZVZllS/eK6DaPsFEOKyyC7I1iO7I.uBtrZZHCxHJK4jt/vua','askifg','asdsdf','Gulbarga','Karnataka','2017-09-05 09:51:03','2017-09-05 09:51:03',1,'bcrypt',NULL,'Male',NULL,NULL,NULL),(25,'fd','df','fd','1999-06-08','$2a$10$W55pnE0aWYdYi8w5o24AOOtHHchgiHxE5dEKSwJ8G1houde.iy3A2','fg','f','fg','Karnataka','2017-09-06 04:43:47','2017-09-06 04:43:47',1,'bcrypt',NULL,'Male',NULL,NULL,NULL),(26,'ram','f','f','2018-04-04','$2a$10$nKGjTQILXUe1j9oZEoll6ugOA515RQgD6JNcLGy9xwPRo7cWqNOTO','f','g','t','Karnataka','2018-03-19 16:45:59','2018-03-19 16:45:59',1,'bcrypt',NULL,'Male',NULL,NULL,NULL);

#
# Structure for table "user_context"
#

DROP TABLE IF EXISTS `user_context`;
CREATE TABLE `user_context` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `context_id` int(11) NOT NULL,
  `campus_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_context_user1_idx` (`user_id`),
  KEY `fk_user_context_context1_idx` (`context_id`),
  KEY `Fk_user_campus_id_idx` (`campus_id`),
  CONSTRAINT `Fk_user_campus_id` FOREIGN KEY (`campus_id`) REFERENCES `campus` (`cmId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_context_context1` FOREIGN KEY (`context_id`) REFERENCES `context` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_context_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

#
# Data for table "user_context"
#

INSERT INTO `user_context` VALUES (13,1,2,3),(14,2,3,4),(15,3,5,4),(16,4,5,4),(17,5,4,4),(18,6,4,4),(19,7,4,4),(20,8,4,4),(21,9,6,4),(22,10,8,4),(23,11,9,4),(24,12,9,4),(25,13,9,4),(26,14,9,4),(27,15,2,5),(28,16,3,7),(29,17,5,7),(30,18,5,7),(31,19,9,7),(32,20,4,7),(33,21,5,7),(34,22,6,7),(35,23,8,7),(36,24,5,7),(37,25,3,4),(38,26,5,4);

#
# Structure for table "user_context_role"
#

DROP TABLE IF EXISTS `user_context_role`;
CREATE TABLE `user_context_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_context_has_role_role1_idx` (`role_id`),
  KEY `fk_user_context_has_role_user_context1_idx` (`user_id`),
  CONSTRAINT `fk_user_context_has_role_role1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_context_has_role_user_context1` FOREIGN KEY (`user_id`) REFERENCES `user_context` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "user_context_role"
#


#
# Structure for table "user_image"
#

DROP TABLE IF EXISTS `user_image`;
CREATE TABLE `user_image` (
  `uId` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `imageName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`uId`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

#
# Data for table "user_image"
#

INSERT INTO `user_image` VALUES (1,2,'administration.jpg'),(2,3,'staff.jpg'),(3,4,'staff.png'),(4,5,'banner1 (1).jpg'),(5,6,'banner1.jpg'),(6,7,'banner5.jpg'),(7,8,'ADM.png'),(8,9,'parent-portal1.png'),(9,10,'Student_School_Portal.png'),(10,16,'images.jpg'),(11,17,'images.jpg'),(12,18,'images.jpg'),(13,19,'images.jpg'),(14,20,'images.jpg'),(15,21,'images.jpg'),(16,22,'images.jpg'),(17,23,'images.jpg'),(18,24,'images.jpg'),(19,25,'ADM.png'),(20,26,'');

#
# Structure for table "user_login"
#

DROP TABLE IF EXISTS `user_login`;
CREATE TABLE `user_login` (
  `ulogId` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) DEFAULT NULL,
  `phone_number` bigint(20) DEFAULT NULL,
  `verified` tinyint(1) DEFAULT '0',
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`ulogId`),
  KEY `fk_user_login_user1_idx` (`user_id`),
  CONSTRAINT `fk_user_login_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

#
# Data for table "user_login"
#

INSERT INTO `user_login` VALUES (14,'org1@gmail.com',9123456789,1,1),(15,'campusadmin1@gmail.com',9012345678,1,2),(16,'Staff1@gmail.com',9012345678,1,3),(17,'staff2@gmail.com',9012345678,1,4),(18,'student@student.com',9012345678,1,5),(19,'student@student.com',9012345678,1,6),(20,'student@student.com',9012345678,1,7),(21,'student@student.com',9012345678,1,8),(22,'parent1@gmail.com',8722467385,1,9),(23,'librarian1@gmail.com',9012345678,1,10),(24,'driver@driver.com',9985545425,1,11),(25,'driver@driver.com',9985545425,1,12),(26,'driver@driver.com',9985545425,1,13),(27,'driver@driver.com',9985545425,1,14),(28,'aashu1130@gmail.com',9964711440,1,15),(29,'camadm@gmail.com',9964744558,1,16),(30,'staff@gmail.com',9964711550,1,17),(31,'stafak@gmail.com',9964711550,1,18),(32,'driver@driver.com',9964718804,1,19),(33,'student@student.com',9964711440,1,20),(34,'stafakk@gmail.com',9964711550,1,21),(35,'parent@gmail.com',9964788550,1,22),(36,'library@gmail.com',9964788550,1,23),(37,'camadm111@gmail.com',9964471140,1,24),(38,'campusadmin2@gmail.com',9087654321,1,25),(39,'ggggggg@gmail.com',9876543210,1,26);

#
# Structure for table "user_term"
#

DROP TABLE IF EXISTS `user_term`;
CREATE TABLE `user_term` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `term_id` int(11) NOT NULL,
  `active` tinyint(1) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_enrollment_term1_idx` (`term_id`),
  KEY `fk_user_enrollment_user_context1_idx` (`user_id`),
  CONSTRAINT `fk_user_enrollment_term1` FOREIGN KEY (`term_id`) REFERENCES `term` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_enrollment_user_context1` FOREIGN KEY (`user_id`) REFERENCES `student_details` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

#
# Data for table "user_term"
#

INSERT INTO `user_term` VALUES (4,5,3,1,0),(5,6,3,1,0),(6,7,3,1,0),(7,8,3,1,0),(8,20,4,1,0);

#
# Structure for table "vehicle"
#

DROP TABLE IF EXISTS `vehicle`;
CREATE TABLE `vehicle` (
  `vdDd` int(11) NOT NULL AUTO_INCREMENT,
  `Maximum_capacity` varchar(255) DEFAULT NULL,
  `No_of_Seat` varchar(255) DEFAULT NULL,
  `Vehicle_code` int(11) NOT NULL,
  `Vehicle_no` int(11) NOT NULL,
  `Vehicle_type_id` varchar(255) DEFAULT NULL,
  `campusId` varchar(255) DEFAULT NULL,
  `insurance` int(11) NOT NULL,
  `permit` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `tax_remitted` int(11) NOT NULL,
  `vdId` int(11) NOT NULL,
  `GpsNumber` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`vdDd`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "vehicle"
#


#
# Structure for table "vehicle_details"
#

DROP TABLE IF EXISTS `vehicle_details`;
CREATE TABLE `vehicle_details` (
  `vdId` int(11) NOT NULL AUTO_INCREMENT,
  `Vehicle_no` varchar(120) DEFAULT NULL,
  `Vehicle_code` varchar(120) DEFAULT NULL,
  `No_of_Seat` int(11) DEFAULT NULL,
  `Maximum_capacity` int(11) DEFAULT NULL,
  `insurance` varchar(120) DEFAULT NULL,
  `tax_remitted` varchar(120) DEFAULT NULL,
  `permit` varchar(120) DEFAULT NULL,
  `GpsNumber` varchar(60) DEFAULT NULL,
  `status` varchar(120) DEFAULT NULL,
  `Vehicle_type_id` int(11) DEFAULT NULL,
  `campusId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`vdId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

#
# Data for table "vehicle_details"
#

INSERT INTO `vehicle_details` VALUES (2,'KA 37','456',45,40,'required','required','required','1234','Good State',1,4),(3,'32','45',20,25,'suresh','manish','no','1234','Good State',1,4),(4,'8862','n7888',20,25,'Yes','Yes','All India Permit','8475612','Good State',1,7);

#
# Structure for table "vehicle_type"
#

DROP TABLE IF EXISTS `vehicle_type`;
CREATE TABLE `vehicle_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Vehicle_type` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Data for table "vehicle_type"
#

INSERT INTO `vehicle_type` VALUES (1,'Bus'),(2,'Cab'),(3,'Van');

#
# Structure for table "vehicledetails"
#

DROP TABLE IF EXISTS `vehicledetails`;
CREATE TABLE `vehicledetails` (
  `vdId` int(11) NOT NULL AUTO_INCREMENT,
  `GpsNumber` varchar(255) DEFAULT NULL,
  `Maximum_capacity` varchar(255) DEFAULT NULL,
  `No_of_Seat` varchar(255) DEFAULT NULL,
  `Vehicle_code` int(11) DEFAULT NULL,
  `Vehicle_no` int(11) DEFAULT NULL,
  `Vehicle_type_id` varchar(255) DEFAULT NULL,
  `campusId` int(11) DEFAULT NULL,
  `insurance` int(11) DEFAULT NULL,
  `permit` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `tax_remitted` int(11) DEFAULT NULL,
  PRIMARY KEY (`vdId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "vehicledetails"
#


#
# Structure for table "weekdaysmaster"
#

DROP TABLE IF EXISTS `weekdaysmaster`;
CREATE TABLE `weekdaysmaster` (
  `dayId` bigint(11) NOT NULL AUTO_INCREMENT,
  `dayName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`dayId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

#
# Data for table "weekdaysmaster"
#

INSERT INTO `weekdaysmaster` VALUES (1,'Monday'),(2,'Tuesday'),(3,'Wednessday'),(4,'Thursday'),(5,'Friday'),(6,'Saturday'),(7,'Sunday');
