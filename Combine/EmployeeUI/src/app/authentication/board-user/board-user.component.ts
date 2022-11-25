import { HttpClient, HttpParams } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

export class Ticket {
  constructor(
    public ticketId: number,
    public title: string,
    public description: string,
    public severity: string,
    public status: string,
    public assignee: Employee,
    public watcher: Employee
  ){}
}

export class Employee {
  constructor(
    public id: number,
    public employeeNumber: string,
    public firstName: string,
    public middleName: string,
    public lastName: string,
    public department: string
  ){}
}

@Component({
  selector: 'app-board-user',
  templateUrl: './board-user.component.html',
  styleUrls: ['./board-user.component.css']
})
export class BoardUserComponent implements OnInit {
  
  tickets!: Ticket[];
  employees!: Employee[];
  
  constructor(private httpClient: HttpClient) { }

  ngOnInit(): void {
    this.getTickets();
    this.getEmployees();
  }

  getTickets(){
    this.httpClient.get<any>('http://localhost:8080/tickets').subscribe(
      response => {
        console.log(response);
        this.tickets = response;
      }
    )
  }

  getEmployees(){
    this.httpClient.get<any>('http://localhost:8080/employees').subscribe(
      response => {
        console.log(response);
        this.employees = response;
      }
    );
  }
}
