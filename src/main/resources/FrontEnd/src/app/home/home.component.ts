import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  content?: string;

  ngOnInit(): void {
    error: (err) => {
      if (err.error) {
        try {
          const res = JSON.parse(err.error);
          this.content = res.message;
        } catch {
          this.content = `Error with status: ${err.status} - ${err.statusText}`;
        }
      } else {
        this.content = `Error with status: ${err.status}`;
      }
    };
  }
}
