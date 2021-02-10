import { Injectable } from '@angular/core';
import Swal from 'sweetalert2'

@Injectable({
  providedIn: 'root'
})
export class PopUpService {

  constructor() { }
  simpleAlert(message: string) {
    Swal.fire({
      imageUrl: 'favicon.ico',
      imageWidth: 80,
      imageHeight: 80,
      html: "<p style='color:#008080;font-size:25px;font-family:cursive'>" + message + "</p>",
      confirmButtonColor: "#008080",

    });
  }
  errorAlert(message: string) {
    Swal.fire({
      icon: 'error',
      title: "<p style='color:#008080;font-size:30px;font-family:cursive'>Oops...</p>",
      html: "<p style='color:#008080;font-size:25px;font-family:cursive'>" + message + "</p>",
      confirmButtonColor: "#008080",
    })
  }


  confirmAlert(message: string) {
    Swal.fire({
      icon: 'success',
      html: "<p style='color:#008080;font-size:25px;font-family:cursive'>" + message + "</p>",
      showConfirmButton: false,
      timer: 3500
    })
  }

  addToCartAlert(message: string) {
    Swal.fire({
      icon: 'success',
      html: "<p style='color:#008080;font-size:25px;font-family:cursive'>" + message + "</p>",
      showConfirmButton: false,
      timer: 1000
    })
  }

  emptyListAlert(message: string) {
    Swal.fire({
      icon: 'warning',
      title: "<p style='color:#008080;font-size:30px;font-family:cursive'>Sorry...</p>",
      html: "<p style='color:#008080;font-size:25px;font-family:cursive'>" + message + "</p>",
      confirmButtonColor: "#008080",
    })
  }


  deleteAlert():any {
    
      Swal.fire({
        title: "<p style='color:#008080;font-size:30px;font-family:cursive'>Are you sure?</p>",
        html: "<p style='color:#008080;font-size:25px;font-family:cursive'>You won't be able to revert this!</p>",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#008080',
        cancelButtonColor: 'btn btn-danger',
        confirmButtonText: 'Yes, delete it!'
      }).then((result) => {
        return result.isConfirmed;
      })
    
  }
}
