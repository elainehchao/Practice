SELECT *
FROM enrollment 
JOIN class
ON enrollment.classID = class.classID
ORDER BY studentID;

SELECT g.StudentID, student.Name, GPA
FROM (
SELECT enrollment.StudentID, (SUM(GradePoint * Num_Credits) / SUM(Num_Credits)) as GPA
FROM enrollment 
JOIN class
ON enrollment.classID = class.classID
GROUP BY enrollment.StudentID
ORDER BY GPA DESC) as g
JOIN Student
ON Student.studentID = g.studentID;


