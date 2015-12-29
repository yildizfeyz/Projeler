function [ x, mu ] = cauchy( xT, d, m, kesin, geridonus )
%CAUCHY Summary of this function goes here
%   Detailed explanation goes here
akesin = ((kesin - xT) / d).^(2*m);
x = 1/ ( 1+akesin);
mu = x;
for t=1:1
if(geridonus == 0) break; end
x = -10:0.1:10;

a = ((x - xT) / d).^(2*m);
mu = 1./ ( 1.+a);

%fprintf(' uyelik derecesi: %f \n ', uyelik);

%plot(x,mu);
end
end

