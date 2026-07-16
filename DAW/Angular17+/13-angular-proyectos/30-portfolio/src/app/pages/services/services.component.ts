import { Component } from '@angular/core';
import { ButtonComponent } from '../../components/button/button.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-services',
  imports: [ButtonComponent],
  templateUrl: './services.component.html',
  styleUrl: './services.component.scss',
})
export class ServicesComponent {
  constructor(public router: Router) {}

  navigate(): void {
    this.router.navigate(['/contact']);
  }
}
