package _08PanzerUnitTesting.models.miscellaneous;

import _08PanzerUnitTesting.contracts.AttackModifyingPart;
import _08PanzerUnitTesting.contracts.DefenseModifyingPart;
import _08PanzerUnitTesting.contracts.HitPointsModifyingPart;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 29.7.2018 г.
 * Time: 14:10 ч.
 */
public class VehicleAssemblerTest {

    private static final double DELTA = 1e-15;

    private VehicleAssembler vehicleAssembler;
    private AttackModifyingPart arsenalParts;
    private DefenseModifyingPart shellParts;
    private HitPointsModifyingPart enduranceParts;

    @Before
    public void setUp() throws Exception {
        this.vehicleAssembler = new VehicleAssembler();

        arsenalParts = Mockito.mock(AttackModifyingPart.class);
        shellParts = Mockito.mock(DefenseModifyingPart.class);
        enduranceParts = Mockito.mock(HitPointsModifyingPart.class);

        vehicleAssembler.addArsenalPart(arsenalParts);
        vehicleAssembler.addShellPart(shellParts);
        vehicleAssembler.addEndurancePart(enduranceParts);
    }

    @Test
    public void getTotalWeight() {
        Mockito.when(arsenalParts.getWeight()).thenReturn(10.0);
        Mockito.when(shellParts.getWeight()).thenReturn(20.0);
        Mockito.when(enduranceParts.getWeight()).thenReturn(30.0);

        double actualTotalWeight = vehicleAssembler.getTotalWeight();
        double expectedTotalWeight = 60.0;

        Assert.assertEquals(expectedTotalWeight, actualTotalWeight, DELTA);
    }

    @Test
    public void getTotalPrice() {
        Mockito.when(arsenalParts.getPrice()).thenReturn(BigDecimal.ZERO);
        Mockito.when(shellParts.getPrice()).thenReturn(BigDecimal.ONE);
        Mockito.when(enduranceParts.getPrice()).thenReturn(BigDecimal.TEN);

        BigDecimal actualTotalWeight = vehicleAssembler.getTotalPrice();
        BigDecimal expectedTotalWeight = BigDecimal.valueOf(11);

        Assert.assertEquals(expectedTotalWeight, actualTotalWeight);
    }

    @Test
    public void getTotalAttackModification() {
        AttackModifyingPart attackModifyingPart = Mockito.mock(AttackModifyingPart.class);
        vehicleAssembler.addArsenalPart(attackModifyingPart);

        Mockito.when(attackModifyingPart.getAttackModifier()).thenReturn(20);
        Mockito.when(arsenalParts.getAttackModifier()).thenReturn(10);

        long actualTotalAttackModification = vehicleAssembler.getTotalAttackModification();
        long expectedTotalAttackModification = 30;

        Assert.assertEquals(expectedTotalAttackModification, actualTotalAttackModification);
    }

    @Test
    public void getTotalDefenseModification() {
        DefenseModifyingPart defenseModifyingPart = Mockito.mock(DefenseModifyingPart.class);
        vehicleAssembler.addShellPart(defenseModifyingPart);

        Mockito.when(defenseModifyingPart.getDefenseModifier()).thenReturn(20);
        Mockito.when(shellParts.getDefenseModifier()).thenReturn(10);

        long actualTotalDefenseModification = vehicleAssembler.getTotalDefenseModification();
        long expectedTotalDefenseModification = 30;

        Assert.assertEquals(expectedTotalDefenseModification, actualTotalDefenseModification);
    }

    @Test
    public void getTotalHitPointModification() {
        HitPointsModifyingPart hitPointsModifyingPart = Mockito.mock(HitPointsModifyingPart.class);
        vehicleAssembler.addEndurancePart(hitPointsModifyingPart);

        Mockito.when(hitPointsModifyingPart.getHitPointsModifier()).thenReturn(20);
        Mockito.when(enduranceParts.getHitPointsModifier()).thenReturn(10);

        long actualTotalHitPointModification = vehicleAssembler.getTotalHitPointModification();
        long expectedTotalHitPointModification = 30;

        Assert.assertEquals(expectedTotalHitPointModification, actualTotalHitPointModification);
    }

    @Test
    public void addArsenalPart() {
        AttackModifyingPart attackModifyingPart = Mockito.mock(AttackModifyingPart.class);
        vehicleAssembler.addArsenalPart(attackModifyingPart);

        Mockito.when(attackModifyingPart.getAttackModifier()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(arsenalParts.getAttackModifier()).thenReturn(10);

        long actualTotalAttackModification = vehicleAssembler.getTotalAttackModification();
        long expectedTotalAttackModification = (long) Integer.MAX_VALUE + 10;

        Assert.assertEquals(expectedTotalAttackModification, actualTotalAttackModification);
    }

    @Test
    public void addShellPart() {
        DefenseModifyingPart defenseModifyingPart = Mockito.mock(DefenseModifyingPart.class);
        vehicleAssembler.addShellPart(defenseModifyingPart);

        Mockito.when(defenseModifyingPart.getDefenseModifier()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(shellParts.getDefenseModifier()).thenReturn(10);

        long actualTotalDefenseModification = vehicleAssembler.getTotalDefenseModification();
        long expectedTotalDefenseModification = (long) Integer.MAX_VALUE + 10;

        Assert.assertEquals(expectedTotalDefenseModification, actualTotalDefenseModification);
    }

    @Test
    public void addEndurancePart() {
        HitPointsModifyingPart hitPointsModifyingPart = Mockito.mock(HitPointsModifyingPart.class);
        vehicleAssembler.addEndurancePart(hitPointsModifyingPart);

        Mockito.when(hitPointsModifyingPart.getHitPointsModifier()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(enduranceParts.getHitPointsModifier()).thenReturn(10);

        long actualTotalHitPointModification = vehicleAssembler.getTotalHitPointModification();
        long expectedTotalHitPointModification = (long) Integer.MAX_VALUE + 10;

        Assert.assertEquals(expectedTotalHitPointModification, actualTotalHitPointModification);
    }
}