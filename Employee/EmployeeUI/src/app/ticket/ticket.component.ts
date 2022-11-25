import { HttpClient, HttpParams } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, NgForm } from '@angular/forms';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';

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
  selector: 'app-ticket',
  templateUrl: './ticket.component.html',
  styleUrls: ['./ticket.component.css']
})
export class TicketComponent implements OnInit {

  tickets: Ticket[];
  employees: Employee[];
  closeResult!: string;
  editForm!: FormGroup;
  addAssignee!: FormGroup;
  addWatcher!: FormGroup;
  private deleteId!: number;
  removeAssignee!: FormGroup;
  removeWatcher!: FormGroup;

  constructor(
    private httpClient: HttpClient,
    private modalService: NgbModal,
    private fb: FormBuilder
  ) { }

  ngOnInit(): void {
    this.getTickets();
    this.getEmployees();

    this.editForm = this.fb.group({
      ticketId: [''],
      title: [''],
      description: [''],
      severity: [''],
      status: ['']
    });

    this.addAssignee = this.fb.group({
      ticketId: [''],
      assignee: ['']
    });

    this.addWatcher = this.fb.group({
      ticketId: [''],
      watcher: ['']
    });

    this.removeAssignee = this.fb.group({
      ticketId: [''],
      assignee: ['']
    });

    this.removeWatcher = this.fb.group({
      ticketId: [''],
      watcher: ['']
    });
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

  onSubmit(f: NgForm){
    const url = 'http://localhost:8080/tickets/addnew';
    this.httpClient.post(url, f.value)
      .subscribe((result) => {
        this.ngOnInit();
      });
      this.modalService.dismissAll();
  }
  
  openAssignee(targetModal: any, ticket: Ticket){
    this.modalService.open(targetModal, {
      centered: true,
      backdrop: 'static',
      size: 'lg'
    });
    this.addAssignee.patchValue({
      ticketId: ticket.ticketId,
    });
  }

  onAddAssignee() {
    let params = new HttpParams();
    params = params.append('ticketId', this.addAssignee.value.ticketId);
    params = params.append('id', this.addAssignee.value.assignee);
    const editURL = 'http://localhost:8080/tickets/assign?' + params;
    console.log(this.addAssignee.value);
    this.httpClient.put(editURL, this.addAssignee.value)
      .subscribe((results) => {
        this.ngOnInit();
        this.modalService.dismissAll();
      });
  }

  openWatcher(targetModal: any, ticket: Ticket){
    this.modalService.open(targetModal, {
      centered: true,
      backdrop: 'static',
      size: 'lg'
    });
    this.addWatcher.patchValue({
      ticketId: ticket.ticketId,
    });
  }

  onAddWatcher() {
    let params = new HttpParams();
    params = params.append('ticketId', this.addWatcher.value.ticketId);
    params = params.append('id', this.addWatcher.value.watcher);
    const editURL = 'http://localhost:8080/tickets/assignWatcher?' + params;
    console.log(this.addWatcher.value);
    this.httpClient.put(editURL, this.addWatcher.value)
      .subscribe((results) => {
        this.ngOnInit();
        this.modalService.dismissAll();
      });
  }

  openDetails(targetModal: any, ticket: Ticket){
    this.modalService.open(targetModal, {
      centered: true,
      backdrop: 'static',
      size: 'lg'
    });
    document.getElementById('tit')?.setAttribute('value', ticket.title);
    document.getElementById('desc')?.setAttribute('value', ticket.description);
    document.getElementById('sever')?.setAttribute('value', ticket.severity);
    document.getElementById('stat')?.setAttribute('value', ticket.status);
  }

  openEdit(targetModal: any, ticket: Ticket){
    this.modalService.open(targetModal, {
      centered: true,
      backdrop: 'static',
      size: 'lg'
    });
    this.editForm.patchValue({
      ticketId: ticket.ticketId,
      title: ticket.title,
      description: ticket.description,
      severity: ticket.severity,
      status: ticket.status
    });
  }

  onSave() {
    const editURL = 'http://localhost:8080/tickets/' + this.editForm.value.ticketId + '/edit';
    console.log(this.editForm.value);
    this.httpClient.put(editURL, this.editForm.value)
      .subscribe((results) => {
        this.ngOnInit();
        this.modalService.dismissAll();
      });
  }

  openDelete(targetModal: any, ticket: Ticket) {
    this.deleteId = ticket.ticketId;
    this.modalService.open(targetModal, {
      backdrop: 'static',
      size: 'lg'
    });
  }

  onDelete() {
    const deleteURL = 'http://localhost:8080/tickets/' + this.deleteId + '/delete';
    this.httpClient.delete(deleteURL)
      .subscribe((results) => {
        this.ngOnInit();
        this.modalService.dismissAll();
      });
  }

  openRemoveAssignee(targetModal: any, ticket: Ticket){
    this.modalService.open(targetModal, {
      centered: true,
      backdrop: 'static',
      size: 'lg'
    });
    this.removeAssignee.patchValue({
      ticketId: ticket.ticketId,
      assignee: ticket.assignee?.id
    });
  }

  onRemoveAssignee() {
    let params = new HttpParams();
    params = params.append('ticketId', this.removeAssignee.value.ticketId);
    params = params.append('id', this.removeAssignee.value.assignee);
    const editURL = 'http://localhost:8080/tickets/removeAssignee?' + params;
    console.log(this.removeAssignee.value);
    this.httpClient.delete(editURL, this.removeAssignee.value)
      .subscribe((results) => {
        this.ngOnInit();
        this.modalService.dismissAll();
      });
  }

  openRemoveWatcher(targetModal: any, ticket: Ticket){
    this.modalService.open(targetModal, {
      centered: true,
      backdrop: 'static',
      size: 'lg'
    });
    this.removeWatcher.patchValue({
      ticketId: ticket.ticketId,
    });
  }

  onRemoveWatcher() {
    let params = new HttpParams();
    params = params.append('ticketId', this.removeWatcher.value.ticketId);
    params = params.append('id', this.removeWatcher.value.watcher);
    const editURL = 'http://localhost:8080/tickets/removeWatcher?' + params;
    console.log(this.removeWatcher.value);
    this.httpClient.delete(editURL, this.removeWatcher.value)
      .subscribe((results) => {
        this.ngOnInit();
        this.modalService.dismissAll();
      });
  }
}
