import com.example.pp3.dto.UsersDto
import com.example.pp3.entity.Users
import com.example.pp3.service.UsersService
import com.example.pp3.util.JSendResponse
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/users")
class UsersController {

    @Autowired
    lateinit var usersService: UsersService

    @GetMapping
    fun getUsers(): ResponseEntity<JSendResponse<List<Users>>> {
        val users = usersService.getUsers()
        return ResponseEntity.ok(JSendResponse.success(users))
    }

    @PostMapping
    fun save(@RequestBody @Valid usersDto: UsersDto): ResponseEntity<JSendResponse<Users>> {
        val savedUsers = usersService.save(usersDto)
        return ResponseEntity.status(200).body(JSendResponse.success(savedUsers))
    }


}
