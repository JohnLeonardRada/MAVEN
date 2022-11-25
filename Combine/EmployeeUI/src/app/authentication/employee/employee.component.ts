import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, NgForm } from '@angular/forms';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';

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
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  employees!: Employee[];
  closeResult!: string;
  editForm!: FormGroup;
  private deleteId!: number;

  constructor(
    private httpClient: HttpClient,
    private modalService: NgbModal,
    private fb: FormBuilder
  ) { }

  ngOnInit(): void {
    this.getEmployees();

    this.editForm = this.fb.group({
      id: [''],
      employeeNumber: [''],
      firstName: [''],
      middleName: [''],
      lastName: [''],
      department: ['']
    });
  }

  getEmployees(){
    this.httpClient.get<any>('http://localhost:8080/employees').subscribe(
      response => {
        console.log(response);
        this.employees = response;
      }
    );
  }

  open(content: any) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }

  onSubmit(f: NgForm) {
    const url = 'http://localhost:8080/employees/addnew';
    this.httpClient.post(url, f.value)
      .subscribe((result) => {
        this.ngOnInit(); //reload the table
      });
    this.modalService.dismissAll(); //dismiss the modal
  }

  openDetails(targetModal: any, employee: Employee) {
    this.modalService.open(targetModal, {
     centered: true,
     backdrop: 'static',
     size: 'lg'
    });
    document.getElementById('empNum')?.setAttribute('value', employee.employeeNumber);
    document.getElementById('fName')?.setAttribute('value', employee.firstName);
    document.getElementById('mName')?.setAttribute('value', employee.middleName);
    document.getElementById('lName')?.setAttribute('value', employee.lastName);
    document.getElementById('dep')?.setAttribute('value', employee.department);
  }

  openEdit(targetModal: any, employee: Employee) {
    this.modalService.open(targetModal, {
    centered: true,
    backdrop: 'static',
    size: 'lg'
    });
    this.editForm.patchValue({
      id: employee.id,
      employeeNumber: employee.employeeNumber,
      firstName: employee.firstName,
      middleName: employee.middleName,
      lastName: employee.lastName,
      department: employee.department
    });
  }

  onSave() {
    const editURL = 'http://localhost:8080/employees/' + this.editForm.value.id + '/edit';
    console.log(this.editForm.value);
    this.httpClient.put(editURL, this.editForm.value)
      .subscribe((results) => {
        this.ngOnInit();
        this.modalService.dismissAll();
      });
  }

  openDelete(targetModal: any, employee: Employee) {
    this.deleteId = employee.id;
    this.modalService.open(targetModal, {
      backdrop: 'static',
      size: 'lg'
    });
  }

  onDelete() {
    const deleteURL = 'http://localhost:8080/employees/' + this.deleteId + '/delete';
    this.httpClient.delete(deleteURL)
      .subscribe((results) => {
        this.ngOnInit();
        this.modalService.dismissAll();
      }, (error) => console.error("Employee is associated to a ticket."));
  }
}
