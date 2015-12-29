function [ output_args ] = uygulama_uyelikfonksiyonlari( input_args )
%UYGULAMA_UYELÝKFONKSÝYONLARÝ Summary of this function goes here
%   Detailed explanation goes here

[x1, y1] = ucgen(1,3,5,1,1);
[x2, y2] = yamuk(1,3,5,7,1,1);
[x3, y3] = sinusoid(3,1,1);
[x4, y4] = sigmoid(-2,0,4,6,1,1);
[x5, y5] = gaussian(3,2,1,1);
[x6, y6] = canuyelik(3,2,4,1,1);
[x7, y7] = cauchy(3,2,4,1,1);


subplot(3,3,1);
plot(x1,y1);
title('ucgen');

subplot(3,3,2);
plot(x2,y2);
title('yamuk');

subplot(3,3,3);
plot(x3,y3);
title('sinusoid');


subplot(3,3,4);
plot(x4,y4);
title('sigmoid');


subplot(3,3,5);
plot(x5,y5);
title('gaussian');


subplot(3,3,6);
plot(x6,y6);
title('can uyelik');


subplot(3,3,7);
plot(x7,y7);
title('cauchy');
end

