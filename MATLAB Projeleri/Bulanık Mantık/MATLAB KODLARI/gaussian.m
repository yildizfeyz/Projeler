function [ x, mu ] = gaussian( xT, w, kesin, geridonus )
%GAUSSÝAN Summary of this function goes here
%   Detailed explanation goes here

akesin = (kesin - xT)/w;
bkesin = (-1/2)*(akesin.^2);
x = exp(bkesin);
mu = x;
for t=1:1
    if(geridonus == 0) break; end
x = -10:0.1:10;

a = (x - xT)/w;
b = (-1/2)*(a.^2);


%fprintf('sayisinin uyelik derecesi: %f \n', uyelikkesin);

mu = exp(b);
%plot(x, mu);
%xlabel('x kesin sayisi');
%ylabel('Uyelik Derecesi');

end
end

