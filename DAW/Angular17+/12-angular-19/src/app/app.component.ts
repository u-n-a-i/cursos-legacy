import { Component } from '@angular/core';

import { FooterComponent } from './shared/components/footer/footer.component';
import { HeaderComponent } from './shared/components/header/header.component';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  imports: [HeaderComponent, FooterComponent, RouterOutlet],
  template: `
    <div
      class="grid min-h-screen grid-rows-[auto_1fr_auto]  max-w-screen-2xl justify-between mx-auto pt-4"
    >
      <app-header class="col-span-3" />
      <router-outlet />
      <app-footer class="col-span-3" />
    </div>
  `,
})
export class AppComponent {
  title = 'workshop-fundamentals';
}
