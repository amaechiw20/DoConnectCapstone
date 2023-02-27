import { Injectable, Injector } from '@angular/core';
import { HttpInterceptor } from '@angular/common/http';
import { ServicesService } from './services.service';

@Injectable({
  providedIn: 'root',
})
export class TokenInterceptorService implements HttpInterceptor {
  constructor(private _injector: Injector) {}

  intercept(req, next) {
    if (req.headers.get('No-Auth') === 'True') {
      return next.handle(req.clone());
    } else {
      let authService = this._injector.get(ServicesService);
      let tokenizedReq = req.clone({
        setHeaders: {
          Authorization: `Bearer ${authService.getToken()}`,
        },
      });
      return next.handle(tokenizedReq);
    }
  }
}
