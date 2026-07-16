import { Component } from '@angular/core';
import { ButtonComponent } from '../../components/button/button.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-introduction',
  imports: [ButtonComponent],
  templateUrl: './introduction.component.html',
  styleUrl: './introduction.component.scss',
})
export class IntroductionComponent {
  greetingText: string = 'Hello! My name is';
  fullName: string = 'Adam Placeholder';
  roleText: string = 'I build solftware solutions';
  introductionText: string = `I'm a software developer focused on creating exceptional digital experiences. 
                              Passionate about everything related to technology, I create user-friendly and efficient applications. 
                              I love tackling complex problems and delivering high-quality work.`;

  aboutMeButtonText: string = 'About Me';

  constructor(public router: Router) {}

  navigate(): void {
    this.router.navigate(['/about-me']);
  }
}
