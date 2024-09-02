-- 20240830 issue_record_table表结构
CREATE TABLE `issue_record_table` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'issue id',
  `issue_description` text COMMENT 'issue specific description',
  `issue_date` varchar(100) DEFAULT NULL COMMENT 'issue report date',
  `issue_status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT 'issue current status',
  `create_time` datetime DEFAULT NULL COMMENT 'issue create time',
  `update_time` datetime DEFAULT NULL COMMENT 'issue update time',
  `report_by` varchar(100) DEFAULT NULL COMMENT 'reporter',
  `comment` varchar(100) DEFAULT NULL COMMENT 'remark',
  `upload_files_path` varchar(255) DEFAULT NULL COMMENT 'Paths to the uploaded files',
  PRIMARY KEY (`id`),
  KEY `issue_record_id_IDX` (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='issue record table';