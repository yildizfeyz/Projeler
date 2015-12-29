function [  ] = oransal_integral_denetim(  )
clear;
A=[-4 -8 -4; 1 0 0;0 1 0];	
B=[0 0 0 ; 0 0 0; 0 0 1];	 C=[ 4 1 6];	 D=0;	
u=[10,10,10];

dt=0.01;	tend=5;	t0=0;	k=1;   
y0=0;  e10=0;

%   Baslangiç degerleri
U0=[10,10,10];    BOY=size(A);  LS=BOY(1); LK=BOY(2);
for n=1:LS
    x0(n)=0;
end

% -----------------Denetim için gerekli veriler
%R0=input('Referans girisi degeri ==> ');
%KP=input('KP girisi degeri ==> ');
%KI=input('KI denetleyici kazancýný giriniz ==> ');
R0 = 10;
KP = 1;
KI = 0;
   while t0<tend-dt
        if t0>(tend/2)  r0=R0+0.5*R0;
        else  r0=R0;
        end
       e0=r0-y0;
       ekp=KP*e0;
       e1=e10+dt*KI*e0;
       e10=e1;   u=(e1+ekp)*U0;
       [x1,x2,x3]=rungekutta(A,B,u,x0,dt);  %Runge ile denklem çöz.
      
       
     UU(k)=u(1);
     e(k)=e0;    r(k)=r0;   y(k)=x0(1); y0=y(k);
     t(k)=t0+dt;    t0=t(k);
         
      x0(1)=x1(1); x0(2)=x2(1);  x0(3)=x3(1); XX(k,1)=x1(1); XX(k,2)=x2(1); XX(k,3)=x3(1); 
      k=k+1;
end;
% -------------------------- Grafikler
subplot(211)
plot(t,y,t,r); xlabel('Zaman (sn)'); ylabel('y');grid
subplot(212)
plot(t,e);  xlabel('Zaman (sn)');  ylabel('e'); grid

end

