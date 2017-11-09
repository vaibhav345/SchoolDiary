import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { StudentService } from "../service/student.service";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent implements OnInit {

  name: String;
  username: String;
  email: String;
  password: String;

  constructor(
    private router: Router,
    private studentService: StudentService
  ) { }

  ngOnInit() {
  }

  onRegisterSubmit() {
    const student = {
      name: this.name,
      email: this.email,
      user_name: this.username,
      password: this.password
    }
    console.log(student)
    this.createStudent(student)
  }

  createStudent(student): void {
    this.studentService.storeStudent(student)
  }

}
