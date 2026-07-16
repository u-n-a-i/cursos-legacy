import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Emoji } from '../models/emoji.model';

@Injectable({
  providedIn: 'root',
})
export class EmojiService {
  private emojisUrl = 'emojis.json';

  constructor(private http: HttpClient) {}

  getEmojis(): Observable<Emoji[]> {
    return this.http.get<Emoji[]>(this.emojisUrl);
  }

  getCategories(emojis: Emoji[]): string[] {
    return [...new Set(emojis.map((emoji) => emoji.category))];
  }
}
