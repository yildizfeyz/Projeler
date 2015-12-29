function [ x, mu ] = ucgen( x1, xT, x2, deger, geridonus )

for t=1:1
    mu1=(deger-x1)/(xT-x1);
    mu2=(x2-deger)/(x2-xT);
    x=max(min(mu1,mu2),0); 
    mu = x; 
    if(geridonus == 0) break; end
    x = -10:0.1:10;
    a = (x-x1)/(xT-x1);     
    b = (x2 - x) / (x2 - xT);
    mu = max(min(a,b), 0.0);
    % plot(x, mu);
    % xlabel('x kesin sayisi'); ylabel('y kesin sayisi');
end
end

