function [ x, mu ] = sinusoid(xT, kesin, geridonus)
%SÝNUSOÝD Summary of this function goes here
%   Detailed explanation goes here
T = 2*xT;
w = pi / T;
x = abs(sin(w*kesin));
mu = x;

for t=1:1
if(geridonus == 0) break; end
D = T / 2;
x1 = xT - D;
x2 = xT + D;
x = -10:0.1:10;

mu = abs(sin(w*x));
for i=1:length(x)
    if(x(i) < x1) mu(i) = 0; end
    if(x(i) > x2) mu(i) = 0; end
end

% plot(x,A);
% xlabel('x kesin degiskeni');
% ylabel('SINUSOID UF');

end
end

