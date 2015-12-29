function [ output_args ] = uygulama_bulanikislemler( input_args )
%UYGULAMA_BULANÝKÝSLEMLER Summary of this function goes here
%   Detailed explanation goes here

[x1, y1] = ucgen(-2,1,4,1,1);
[x2, y2] = ucgen(2,5,8,1,1);

[x3, y3] = gaussian(0,2,1,1);
[x4, y4] = gaussian(6,2,1,1);

[x5, y5] = cauchy(4,2,4,1,1);


[x6, y6] = birlesim(x1,y1,x2,y2);
[x7, y7] = kesisim(x3,y3,x4,y4);
[x8, y8] = degilleme(x5, y5);



subplot(3,2,1);
plot(x1,y1,x2,y2);


subplot(3,2,2);
plot(x6,y6);
title('Birleþim');

subplot(3,2,3);
plot(x3,y3,x4,y4);



subplot(3,2,4);
plot(x7,y7);
title('Kesiþim');
axis([-10,10,0,1]);

subplot(3,2,5);
plot(x5,y5);



subplot(3,2,6);
plot(x8,y8);
title('Deðilleme');

end

