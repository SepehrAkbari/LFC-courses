# May 8, 2023
xn_Diesel  = 4.05
yn_Diesel = 8
xn_Regular  = 3.54
yn_Regular = 8

# MAy 6, 2024
xk_Diesel = 3.97
yk_Diesel = 6
xk_Regular = 3.65
yk_Regular = 6

# May 13, 2024
xl_Diesel = 3.93
yl_Diesel = 13
xl_Regular = 3.62
yl_Regular = 13

# May 8, 2024
slopeRegular = (xl_Regular - xk_Regular) / (yl_Regular - yk_Regular)
slopeDiesel = (xl_Diesel - xk_Diesel) / (yl_Diesel - yk_Diesel)

regularPrice = (slopeRegular * (8-1)) + xk_Regular
dieselPrice = (slopeDiesel * (8-1)) + xk_Diesel

# Difference
differenceRegular = regularPrice - xn_Regular
differenceDiesel = dieselPrice - xn_Diesel

# output
print("Regular Price: ", regularPrice) # 3.62
print("Diesel Price: ", dieselPrice) # 3.93
print("Difference in Regular Price: ", differenceRegular) # 0.08
print("Difference in Diesel Price: ", differenceDiesel) # -0.12