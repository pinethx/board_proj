-- web_gradle_erp.board definition
drop table board;

CREATE TABLE `board` (
  `BOARD_NUM` int(11) NOT NULL COMMENT '글 번호',
  `BOARD_NAME` varchar(20) NOT NULL COMMENT '글 작성자',
  `BOARD_PASS` varchar(15) NOT NULL COMMENT '글 비밀번호',
  `BOARD_SUBJECT` varchar(50) NOT NULL COMMENT '글 제목',
  `BOARD_CONTENT` varchar(2000) NOT NULL COMMENT '글 내용',
  `BOARD_FILE` varchar(50) NOT NULL COMMENT '첨부파일',
  
  `BOARD_RE_REF` int(11) NOT NULL COMMENT '관련글 번호',
  
  `BOARD_RE_LEV` int(11) NOT NULL DEFAULT '0' COMMENT '답글 레벨',
  `BOARD_RE_SEQ` int(11) NOT NULL DEFAULT '0' COMMENT '관련글 중 출력 순서',
  `BOARD_READCOUNT` int(11) DEFAULT '0' COMMENT '조회수',
  
  `BOARD_DATE` datetime DEFAULT current_timestamp COMMENT '작성일',
  PRIMARY KEY (`BOARD_NUM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;