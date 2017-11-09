package org.application.schooldiary;

import org.application.schooldiary.database.CreateSchoolDiaryDB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SchoolDiaryApplication {

	public static void main(String[] args) {
		/** Crete the schoolDiary Database before running the Application.
		 */
		CreateSchoolDiaryDB createSchoolDiaryDB = new CreateSchoolDiaryDB();
		createSchoolDiaryDB.main(args);

		SpringApplication.run(SchoolDiaryApplication.class, args);
	}
}
