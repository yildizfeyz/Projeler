function [ x1, x2, x3 ] = rungekutta(A,B,U,xdizi,dt)
%RUNGEKUTTA Summary of this function goes here
%   Detailed explanation goes here

%A = [-4, -8, -4; 
%       1, 0, 0; 
%       0, 1, 0];
%B = [1, 0, 0; 
%    0, 0, 0 ; 
%    0, 0, 0];
%U = [10, 10, 10];
%xdizi = [0, 0, 0];
%dt = 0.01;
C = [4,1,6];
D = 0;
x10 = xdizi(1);    x20 = xdizi(2);    x30 = xdizi(3); 
u1 = U(1); u2 = U(2); u3 = U(3);
u = [u1, u2, u3];

tend = 5;
t0 = 0;
k = 1;


while t0 < tend
x11 = x10; x21 = x20; x31 = x30;

a1 = dt*(A(1,1)*x11 + A(1,2)*x21 + A(1,3)*x31 + B(1,1)*u(1) + B(1,2)*u(2) + B(1,3) * u(3)); 
a2 = dt*(A(2,1)*x11 + A(2,2)*x21 + A(2,3)*x31 + B(2,1)*u(1) + B(2,2)*u(2) + B(2,3) * u(3)); 
a3 = dt*(A(3,1)*x11 + A(3,2)*x21 + A(3,3)*x31 + B(3,1)*u(1) + B(3,2)*u(2) + B(3,3) * u(3)); 

x12 = x10 + a1/2;     x22 = x20 + a2/2;     x32 = x30 + a3/2;

b1 = dt*(A(1,1)*x12 + A(1,2)*x22 + A(1,3)*x32 + B(1,1)*u(1) + B(1,2)*u(2) + B(1,3) * u(3)); 
b2 = dt*(A(2,1)*x12 + A(2,2)*x22 + A(2,3)*x32 + B(2,1)*u(1) + B(2,2)*u(2) + B(2,3) * u(3)); 
b3 = dt*(A(3,1)*x12 + A(3,2)*x22 + A(3,3)*x32 + B(3,1)*u(1) + B(3,2)*u(2) + B(3,3) * u(3)); 

x13 = x10 + b1/2;     x23= x20 + b2/2;      x33 = x30 + b3/2;

c1 = dt*(A(1,1)*x13 + A(1,2)*x23 + A(1,3)*x33 + B(1,1)*u(1) + B(1,2)*u(2) + B(1,3) * u(3)); 
c2 = dt*(A(2,1)*x13 + A(2,2)*x23 + A(2,3)*x33 + B(2,1)*u(1) + B(2,2)*u(2) + B(2,3) * u(3)); 
c3 = dt*(A(3,1)*x13 + A(3,2)*x23 + A(3,3)*x33 + B(3,1)*u(1) + B(3,2)*u(2) + B(3,3) * u(3)); 

x14 = x10 + c1;       x24 = x20 + c2;       x34 = x30 + c3;

d1 = dt*(A(1,1)*x14 + A(1,2)*x24 + A(1,3)*x34 + B(1,1)*u(1) + B(1,2)*u(2) + B(1,3) * u(3)); 
d2 = dt*(A(2,1)*x14 + A(2,2)*x24 + A(2,3)*x34 + B(2,1)*u(1) + B(2,2)*u(2) + B(2,3) * u(3)); 
d3 = dt*(A(3,1)*x14 + A(3,2)*x24 + A(3,3)*x34 + B(3,1)*u(1) + B(3,2)*u(2) + B(3,3) * u(3)); 

x1(k) = x10 + (a1 +2*b1 + 2*c1 + d1)/6;
x2(k) = x20 + (a2 +2*b2 + 2*c2 + d2)/6;
x3(k) = x20 + (a3 +2*b3 + 2*c3 + d3)/6;


U(k) = u1; t(k) = t0 + dt; t0 = t(k);
x10 = x1(k); x20 = x2(k); k = k+1;
end

% subplot(311);
% plot(t,x1);
% title('x1');
% xlabel('saniye'); ylabel('x1');
% grid
% 
% subplot(312);
% plot(t,x2);
% title('x2');
% xlabel('saniye'); ylabel('x2');
% grid
% 
% subplot(313);
% plot(t,x3);
% title('x3');
% xlabel('saniye'); ylabel('x3');
% grid


end

