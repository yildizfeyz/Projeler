function [ output_args ] = uygulama_CGTK( input_args )
%UYGULAMA_CGTK Summary of this function goes here
%   Detailed explanation goes here

[Ax(:,1), Ay(:,1)] = ucgen(0,2,4,1,1);
[Bx(:,1), By(:,1)] = ucgen(0.3,2.3,4.3,1,1);

[Ax(:,2), Ay(:,2)] = ucgen(0,2,4,1,1);
[Bx(:,2), By(:,2)] = ucgen(2,4,6,1,1);

[Ax(:,3), Ay(:,3)] = gaussian(2,2,6,1);
[Bx(:,3), By(:,3)] = gaussian(5,2,4,1);

[Cx, Cy] = yamuk(-1,2,3,4,1,1);

CGTK(Ax, Ay, Bx, By, Cx, Cy, 3);
end

