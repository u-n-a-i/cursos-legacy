import { Component } from '@angular/core';
import { ButtonComponent } from '../../components/button/button.component';

@Component({
  selector: 'app-contact',
  imports: [ButtonComponent],
  templateUrl: './contact.component.html',
  styleUrl: './contact.component.scss',
})
export class ContactComponent {
  phoneNumber = '+1 923 673 131';
  email = 'adam.placeholder@gmail.com';
  sendData(): void {
    console.log('sends data to its place');
  }
}
