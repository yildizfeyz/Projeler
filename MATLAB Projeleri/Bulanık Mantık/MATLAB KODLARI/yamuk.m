function [ x, mu ] = yamuk(x1, xT1, xT2, x2 , kesin, geridonus )
%YAMUK Summary of this function goes here
%   Detailed explanation goes here


akesin = (kesin - x1) / (xT1 - x1);
bkesin = (x2 - kesin) / (x2 - xT2); 
x = max(min(min(akesin,bkesin), 1),0);
mu = x;
for t=1:1
if(geridonus == 0) break; end

x = -10:0.1:10;

a = (x - x1) / (xT1 - x1);
b = (x2 - x) / (x2 - xT2);



mu = max(min(1,min(a,b)),0);


%fprintf(' x kesin uyelik derecesi: %f \n', kesinderece);

% plot(x, mu);
% axis([-2,20,0,1]);
% 
% xlabel('x kesin sayisi');
% ylabel('y kesin sayisi');
end

end

