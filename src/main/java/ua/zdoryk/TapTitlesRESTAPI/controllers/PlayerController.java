package ua.zdoryk.TapTitlesRESTAPI.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import ua.zdoryk.TapTitlesRESTAPI.dto.PlayerDTO;
import ua.zdoryk.TapTitlesRESTAPI.models.Player;
import ua.zdoryk.TapTitlesRESTAPI.services.PlayerService;
import ua.zdoryk.TapTitlesRESTAPI.util.Response;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/players")
@Transactional(readOnly = true)
@CrossOrigin("http://localhost:4200/")
public class PlayerController {

    private final PlayerService playerService;

    private final ModelMapper modelMapper;

    @Autowired
    public PlayerController(PlayerService playerService, ModelMapper modelMapper) {
        this.playerService = playerService;
        this.modelMapper = modelMapper;
    }

    @GetMapping()
    public List<Player> getPlayers(){
        return playerService.getAll();
    }

    @GetMapping("/player")
    public Object getPlayerByName(@RequestBody Player player)
    {
        if(player.getName() == null || player.getName().isEmpty()){
            return ResponseEntity.badRequest().body(new Response(HttpStatus.NOT_FOUND,"Empty fields"));
        }
        Player playerToReturn = playerService.getPlayerByName(player.getName());

        if(playerToReturn == null){
            return ResponseEntity.badRequest().body(new Response(HttpStatus.NOT_FOUND,"not found"));
        }
        return playerToReturn;
    }

    @PostMapping("/register")
    @Transactional
    public ResponseEntity<?> RegisterPlayer(@RequestBody @Valid PlayerDTO playerDTO, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            StringBuilder errors = new StringBuilder();
            List<FieldError> errorList = bindingResult.getFieldErrors();
            for(FieldError error: errorList)
                errors.append(error.getField()).append(" - ").append(error.getDefaultMessage()).append("; ");

            return ResponseEntity.badRequest().body(new Response(HttpStatus.BAD_GATEWAY,errors.toString()));
        }
        Player player = convertToPlayer(playerDTO);

        if(playerService.getAll().stream().anyMatch(x -> x.getName().equals(player.getName()))){
            return ResponseEntity.badRequest().body(new Response(HttpStatus.CONFLICT,"this name already exist"));
        }
        playerService.addUser(player);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }


    private Player convertToPlayer(PlayerDTO playerDTO){
        return modelMapper.map(playerDTO, Player.class);
    }
    private PlayerDTO convertToPlayerDTO(Player player){
        return modelMapper.map(player,PlayerDTO.class);
    }
    
}
