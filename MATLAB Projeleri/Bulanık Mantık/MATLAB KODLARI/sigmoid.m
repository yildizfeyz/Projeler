function [ x, mu ] = sigmoid( aL, cL,   cR,aR, kesin, geridonus )
%SÝGMOÝD Summary of this function goes here
%   Detailed explanation goes here

bkesin = 1/(1+exp(-aL*(kesin-cL))); 
ckesin = 1/(1+exp(-aR*(kesin-cR))); 
x = max(bkesin, ckesin);
mu = x;
for t=1:1

    if(geridonus == 0) break; end
    %fprintf('Uyelik Derecesi: %f \n', x);
x=-10:0.001:10;
b = 1./(1+exp(-aL*(x-cL))); 
c = 1./(1+exp(-aR*(x-cR))); 

for i=1:length(x)
    mu(i) = max(b(i), c(i));
end


%plot(x,b,x,c);
end
end

