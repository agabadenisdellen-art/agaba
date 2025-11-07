# grade_calculator.py
# This program will calculate a student's final grade based on coursework and exam scores.

def get_student_inputs():
    """Gets student details and scores from the user."""
    student_name = input("Enter the student's name: ")
    course_unit = input("Enter the course unit: ")

    # Get and validate coursework 1 score
    while True:
        try:
            cw1_score = float(input("Enter Coursework 1 score (out of 30): "))
            if 0 <= cw1_score <= 30:
                break
            else:
                print("Invalid score. Please enter a value between 0 and 30.")
        except ValueError:
            print("Invalid input. Please enter a number.")

    # Get and validate coursework 2 score
    while True:
        try:
            cw2_score = float(input("Enter Coursework 2 score (out of 30): "))
            if 0 <= cw2_score <= 30:
                break
            else:
                print("Invalid score. Please enter a value between 0 and 30.")
        except ValueError:
            print("Invalid input. Please enter a number.")

    # Get and validate final exam score
    while True:
        try:
            exam_score = float(input("Enter Final Exam score (out of 100): "))
            if 0 <= exam_score <= 100:
                break
            else:
                print("Invalid score. Please enter a value between 0 and 100.")
        except ValueError:
            print("Invalid input. Please enter a number.")

    return student_name, course_unit, cw1_score, cw2_score, exam_score

def calculate_final_grade(cw1_score, cw2_score, exam_score):
    """Calculates the weighted scores and the final grade."""
    # Weight coursework scores (out of 15 each)
    weighted_cw1 = (cw1_score / 30) * 15
    weighted_cw2 = (cw2_score / 30) * 15

    # Calculate final coursework score (out of 30)
    final_coursework_score = weighted_cw1 + weighted_cw2

    # Weight final exam score (out of 70)
    weighted_exam = (exam_score / 100) * 70

    # Calculate final total mark (out of 100)
    final_mark = final_coursework_score + weighted_exam

    return final_coursework_score, weighted_exam, final_mark

def display_results(student_name, course_unit, final_coursework_score, weighted_exam, final_mark):
    """Displays the final grade report."""
    print("\n" + "="*30)
    print("      STUDENT GRADE REPORT")
    print("="*30)
    print(f"Student Name: {student_name}")
    print(f"Course Unit:  {course_unit}")
    print("-"*30)
    print(f"Final Coursework Mark: {final_coursework_score:.2f} / 30")
    print(f"Final Exam Mark:       {weighted_exam:.2f} / 70")
    print("-"*30)
    print(f"FINAL TOTAL MARK:      {final_mark:.2f} / 100")
    print("="*30)

# Main execution block
if __name__ == "__main__":
    # Get inputs from the user
    student_name, course_unit, cw1_score, cw2_score, exam_score = get_student_inputs()

    # Calculate the final grade
    final_coursework_score, weighted_exam, final_mark = calculate_final_grade(
        cw1_score, cw2_score, exam_score
    )

    # Display the final report
    display_results(student_name, course_unit, final_coursework_score, weighted_exam, final_mark)
