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

-- 20240923更新高阶产品表添加标志提醒字段 
-- 上线步骤先更新数据库中的表结构，增加remind字段。
-- 根据数据编写更新语句给remind字段赋值。
-- 再重新启动程序。
ALTER TABLE tpcs_data_base.high_technology_record_table ADD remind varchar(10) NULL COMMENT '标志位';