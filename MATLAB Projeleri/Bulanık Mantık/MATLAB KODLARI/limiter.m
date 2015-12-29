function [ E ] = limiter( EMIN, EMAX, ee )
%LÝMÝTER Summary of this function goes here
%   Detailed explanation goes here
if(ee < EMIN)
    E = EMIN
elseif(ee > EMAX)
    E = EMAX;
else
    E = ee;
end
end

