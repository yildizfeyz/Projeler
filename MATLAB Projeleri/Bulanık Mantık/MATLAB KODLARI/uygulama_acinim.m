function [ output_args ] = uygulama_acinim( input_args )
%UYGULAMA_ACÝNÝM Summary of this function goes here
%   Detailed explanation goes here

[x1, y1] = ucgen(0,2,4,1,1);

[x2, y2] = acinim(x1, y1, 2, 0, -1);


plot(x2, y2);
title('ucgen fonksiyonuna 2x^2 - 1 ile acinim yapýlmýþ hali')

end

