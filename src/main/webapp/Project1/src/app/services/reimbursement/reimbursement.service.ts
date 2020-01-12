import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Reimbursement } from '../../models/reimbursement';
@Injectable({
  providedIn: 'root'
})
export class ReimbursementService {

  constructor(private http: HttpClient) { }

  getReimbursements(){
    return this.http.get('https://localhost:8080/project-1/reimbursements');
  }
}
