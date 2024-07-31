package io.lumine.mythic.apiexamples.factionprovider;

import io.lumine.mythic.api.adapters.AbstractPlayer;
import io.lumine.mythic.core.players.factions.FactionProvider;
import org.bukkit.Bukkit;

import java.util.Optional;
import java.util.UUID;

/**
 * Returns the faction based on the length of a player's username
 */
public class ExampleFactionProvider implements FactionProvider {

    /**
     * Checks if a player is in the provided faction
     * @param abstractPlayer The player to check
     * @param s The faction to check against
     * @return If the player is in the faction. If they aren't in a faction will return false no matter the value of s.
     */
    @Override
    public boolean isInFaction(AbstractPlayer abstractPlayer, String s) {
        Optional<String> faction = getFaction(abstractPlayer);
        return faction.map(string -> string.equals(s)).orElse(false);
    }

    @Override
    public Optional<String> getFaction(UUID uuid) {
        return String.valueOf(Bukkit.getPlayer(uuid).getName().length()).describeConstable();
    }
}
