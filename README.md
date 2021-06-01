This is an maze test example [Under construction]

## Assumptions
Only considered the given requirements.
1. No backward movement for explorer.

## Code improvements.
1. Unit tests are not mocked to save time.
2. No interface programming done for Explorer and Maze for now.
3. For unit tests not mocked for now to save some time.
4. Logging could have been improved, for time being used the java util log.
5. Tests could have been slightly improved for exceptional cases, but tried to cover ASAP. 


**To Run as spring boot**    

mvn spring-boot:run
OR
Run the Application.java from your IDE

**Below given an example of how to play:**  
'S' indicates Start position, '*' indicates current position.

1. S indicates starting position below, Forward, right movement allowed here  

XXXX    
X XX  
XS X  
XX X  
XX X  
XXEX  

2. After press R, * indicates current position, only RIGHT available from there.  

XXXX   
X XX  
XS*X  
XX X  
XX X  
XXEX  

3. After press F, * indicates current position, only FORWARD available from there.   
    
XXXX   
X XX  
XS X  
XX*X  
XX X  
XXEX  

END
