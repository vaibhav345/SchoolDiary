import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import 'rxjs/add/operator/map';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class StudentService {
  student: any;
  private headers = new HttpHeaders({'Content-Type':'application/json'});

  constructor(private http:HttpClient) {}

  // Will need this in future!!
/**
  getStudents(): Observable<any>{
    return this.http.get('/all')
      .map(
        (response: Response) => {
          return response.json();
        }
      );
  }
**/

  storeStudent(student) {
    return this.http
      .post("/students/register", JSON.stringify(student), { headers: this.headers })
      .toPromise()
  }

}
