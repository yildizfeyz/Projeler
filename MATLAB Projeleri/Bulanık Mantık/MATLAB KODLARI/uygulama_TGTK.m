function [  ] = uygulama_TGTK(  )
%UYGULAMA_BULANÝKSONUCLANDÝRMA Summary of this function goes here
%   Detailed explanation goes here
[x1, y1] = ucgen(0,2,4,1,1);
[x2, y2] = ucgen(2,4,6,1,1);
[x3, y3] = ucgen(0,2,4,1,1);

TGTK(x1,y1,x2,y2,x3,y3);

end

